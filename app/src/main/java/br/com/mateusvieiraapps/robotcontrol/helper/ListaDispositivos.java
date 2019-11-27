package br.com.mateusvieiraapps.robotcontrol.helper;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Set;

import br.com.mateusvieiraapps.robotcontrol.R;

/**
 * Esta classe é uma caixa de dialogo mostrando os dispositivos Bluetooth's disponíveis para conectar.
 *
 * @author Mateus V Machado
 * @version 1.1.0
 * @since 1.0.0
 */
public class ListaDispositivos extends ListActivity {

    protected static String ENDERECO_MAC = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        arrayCreate();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);

        String informacaoGeral = ((TextView) v).getText().toString();
        String enderecoMac = informacaoGeral.substring(informacaoGeral.length() - 17);

        Intent retornaMac = new Intent();
        retornaMac.putExtra(ENDERECO_MAC, enderecoMac);
        setResult(RESULT_OK, retornaMac);
        finish();
    }

    private void arrayCreate() {

        ArrayAdapter<String> arrayBluetooth = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        BluetoothAdapter meuBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        Set<BluetoothDevice> dispositivosPareados = meuBluetoothAdapter.getBondedDevices();

        if (dispositivosPareados.size() > 0) {

            for (BluetoothDevice dispositivo : dispositivosPareados) {

                String nomeBluetooth = dispositivo.getName();
                String enderecoMac = dispositivo.getAddress();
                arrayBluetooth.add("\n" + nomeBluetooth + "\n" + getString(R.string.msg_mac) + " " + enderecoMac);
            }
        }

        setListAdapter(arrayBluetooth);
    }
}
