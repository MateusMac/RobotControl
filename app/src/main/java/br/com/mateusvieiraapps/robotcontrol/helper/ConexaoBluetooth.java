package br.com.mateusvieiraapps.robotcontrol.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;

import br.com.mateusvieiraapps.robotcontrol.R;
import br.com.mateusvieiraapps.robotcontrol.activity.BaseApp;

/**
 * Esta classe tem o objetivo de realizar a conexão com o módulo Bluetooth.
 * Ela verifica e conecta com o serial Bluetooth.
 * É a Super Class das classes dos layouts.
 *
 * @author Mateus V Machado
 * @version 1.0.4
 * @since 1.0.0
 */
@SuppressLint("Registered")
public class ConexaoBluetooth extends BaseApp {

    protected static boolean conexao = false;

    private static final int SOLICITA_ATIVACAO = 1;
    private static final int SOLICITA_CONEXAO = 2;
    protected static final int MESSAGE_READ = 3;
    private static final UUID MEU_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    protected static BluetoothAdapter meuBluetoothAdapter = null;
    protected static BluetoothDevice meuDevice = null;
    protected static BluetoothSocket meuSocket = null;

    protected static Handler mHandler = null;

    private static ConnectedThread connectedThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        meuBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (meuBluetoothAdapter == null) {

            mostrarToast(getString(R.string.msg_nao_possui_bluetooth), Toast.LENGTH_LONG);
            finish();
        } else if (!meuBluetoothAdapter.isEnabled()) {

            this.solicitaBluetooth();
        } else if (meuBluetoothAdapter.isEnabled() && !conexao) {

            mostrarToast(getString(R.string.msg_sem_dispositivo_pareado), Toast.LENGTH_LONG);
            this.solicitaConexao();
        }
    }

    protected void solicitaBluetooth() {

        try {

            Intent ativaBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(ativaBluetooth, SOLICITA_ATIVACAO);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    protected void solicitaConexao() {

        try {

            Intent abreLista = new Intent(getApplicationContext(), ListaDispositivos.class);
            startActivityForResult(abreLista, SOLICITA_CONEXAO);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    protected void falhaAoEnviar() {

        if (!meuBluetoothAdapter.isEnabled()) {

            try {

                mostrarToast(getString(R.string.msg_bluetooth_nao_ativado), Toast.LENGTH_LONG);
                solicitaBluetooth();
            } catch (Exception e) {

                e.printStackTrace();
                Log.e("ERRO: ", e.toString());
            }
        }

        if (meuBluetoothAdapter.isEnabled() && !conexao) {

            try {

                mostrarToast(getString(R.string.msg_sem_dispositivo_pareado), Toast.LENGTH_LONG);
                solicitaConexao();
            } catch (Exception e) {

                e.printStackTrace();
                Log.e("ERRO: ", e.toString());
            }
        }
    }

    protected void enviarInformacao(String letra) {

        if (meuBluetoothAdapter.isEnabled() && conexao) {

            connectedThread.enviar(letra);
            Log.i(getString(R.string.info_), letra);
            //mostrarToast(letra);
        } else {

            this.falhaAoEnviar();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case SOLICITA_ATIVACAO:
                if (resultCode == Activity.RESULT_OK) {

                    mostrarToast(getString(R.string.msg_bluetooth_ativado));
                    solicitaConexao();
                    mostrarToast(getString(R.string.msg_conecte_dispositivo));
                } else {

                    mostrarToast(getString(R.string.msg_bluetooth_nao_ativado), Toast.LENGTH_LONG);
                    this.solicitaBluetooth();
                }

                break;

            case SOLICITA_CONEXAO:
                if (resultCode == Activity.RESULT_OK) {

                    String MAC = Objects.requireNonNull(data.getExtras()).getString(ListaDispositivos.ENDERECO_MAC);
                    meuDevice = meuBluetoothAdapter.getRemoteDevice(MAC);

                    try {

                        meuSocket = meuDevice.createRfcommSocketToServiceRecord(MEU_UUID);
                        meuSocket.connect();
                        conexao = true;
                        connectedThread = new ConnectedThread(meuSocket);
                        connectedThread.start();
                        mostrarToast(getString(R.string.msg_conectado_mac) + " " + MAC);
                    } catch (IOException erro) {

                        conexao = false;
                        mostrarToast(getString(R.string.msg_falha_ao_conectar) + " " + MAC);
                    }

                } else {

                    conexao = false;
                    mostrarToast(getString(R.string.msg_falha_obter_mac), Toast.LENGTH_LONG);
                    this.solicitaConexao();
                }
        }
    }

    protected class ConnectedThread extends Thread {

        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        private ConnectedThread(BluetoothSocket socket) {

            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            try {

                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) {

                e.printStackTrace();
            }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {

            byte[] buffer = new byte[1024];
            int bytes;

            while (true) {
                try {

                    bytes = mmInStream.read(buffer);
                    String dadosBt = new String(buffer, 0, bytes);
                    mHandler.obtainMessage(MESSAGE_READ, bytes, -1, dadosBt).sendToTarget();
                } catch (IOException e) {

                    e.printStackTrace();
                    break;
                }
            }
        }

        private void enviar(String enviarDados) {

            byte[] msgBuffer = enviarDados.getBytes();

            try {

                mmOutStream.write(msgBuffer);
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}
