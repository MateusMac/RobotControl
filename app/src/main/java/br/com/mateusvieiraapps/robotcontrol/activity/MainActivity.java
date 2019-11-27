package br.com.mateusvieiraapps.robotcontrol.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import br.com.mateusvieiraapps.robotcontrol.R;
import br.com.mateusvieiraapps.robotcontrol.helper.ConexaoBluetooth;

/**
 * Classe principal do App Robot Control.
 * <p>
 * O App tem a capacidade de controlar de forma simples o módulo Bluetooth do Arduino.
 *
 * @author Mateus V Machado
 * @version 1.1.3
 * @see ConexaoBluetooth
 * @since 1.0.0
 */
public class MainActivity extends DefinitionsVariables {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.atribuirBotoes();
        this.enviarComando();
    }

    public void botaoConectar(View view) {

        if (meuBluetoothAdapter.isEnabled() && conexao) {

            try {

                meuSocket.close();
                conexao = false;
                mostrarToast(getString(R.string.msg_bluetooth_desconectado));
            } catch (IOException erro) {

                mostrarToast(getString(R.string.msg_falha_ao_conectar) + erro);
                erro.printStackTrace();
            }
        } else if (!meuBluetoothAdapter.isEnabled()) {

            mostrarToast(getString(R.string.msg_bluetooth_nao_ativado), Toast.LENGTH_LONG);
            solicitaBluetooth();
        } else if (meuBluetoothAdapter.isEnabled() && !conexao) {

            solicitaConexao();
        }
    }

    private void enviarComando() {

        imgFrente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("W");
            }
        });

        imgFrente.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterFrente());
                return false;
            }
        });

        imgFrente.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgDireita.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("D");
            }
        });

        imgDireita.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterDireita());
                return false;
            }
        });

        imgDireita.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgAtras.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("S");
            }
        });

        imgAtras.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterAtras());
                return false;
            }
        });

        imgAtras.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgEsquerda.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("A");
            }
        });

        imgEsquerda.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterEsquerda());
                return false;
            }
        });

        imgEsquerda.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgGiroEsq.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("Q");
            }
        });

        imgGiroEsq.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterGiroEsquerda());
                return false;
            }
        });

        imgGiroEsq.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgGiroDir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("E");
            }
        });

        imgGiroDir.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterGiroDireita());
                return false;
            }
        });

        imgGiroDir.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgMais.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("M");
            }
        });

        imgMais.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterMais());
                return false;
            }
        });

        imgMais.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgMenos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("N");
            }
        });

        imgMenos.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterMenos());
                return false;
            }
        });

        imgMenos.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgSom1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("T");
            }
        });

        imgSom1.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterSom1());
                return false;
            }
        });

        imgSom1.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgSom2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("Y");
            }
        });

        imgSom2.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterSom2());
                return false;
            }
        });

        imgSom2.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgSom3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("U");
            }
        });

        imgSom3.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterSom3());
                return false;
            }
        });

        imgSom3.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgSom4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("I");
            }
        });

        imgSom4.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterSom4());
                return false;
            }
        });

        imgSom4.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgSom5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("O");
            }
        });

        imgSom5.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterSom5());
                return false;
            }
        });

        imgSom5.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgDanca1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("G");
            }
        });

        imgDanca1.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterDanca1());
                return false;
            }
        });

        imgDanca1.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgDanca2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("H");
            }
        });

        imgDanca2.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterDanca2());
                return false;
            }
        });

        imgDanca2.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgDanca3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("J");
            }
        });

        imgDanca3.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterDanca3());
                return false;
            }
        });

        imgDanca3.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgDanca4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("K");
            }
        });

        imgDanca4.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterDanca4());
                return false;
            }
        });

        imgDanca4.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });

        imgDanca5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                enviarInformacao("L");
            }
        });

        imgDanca5.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View arg0) {

                mAutoIncrement = true;
                repeatUpdateHandler.post(new UpdaterDanca5());
                return false;
            }
        });

        imgDanca5.setOnTouchListener(new View.OnTouchListener() {

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if ((event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) && mAutoIncrement) {

                    mAutoIncrement = false;
                }

                return false;
            }
        });
    }
}
