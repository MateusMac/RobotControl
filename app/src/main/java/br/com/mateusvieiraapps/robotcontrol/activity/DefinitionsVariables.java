package br.com.mateusvieiraapps.robotcontrol.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageButton;

import br.com.mateusvieiraapps.robotcontrol.R;
import br.com.mateusvieiraapps.robotcontrol.helper.ConexaoBluetooth;

/**
 * Classe para armazenar variaveis de definições do App.
 *
 * @author Mateus V Machado
 * @version 1.0.1
 * @see ConexaoBluetooth
 * @since 1.0.5
 */
@SuppressLint("Registered")
public class DefinitionsVariables extends ConexaoBluetooth {

    protected ImageButton imgFrente = null;
    protected ImageButton imgDireita = null;
    protected ImageButton imgAtras = null;
    protected ImageButton imgEsquerda = null;
    protected ImageButton imgGiroEsq = null;
    protected ImageButton imgGiroDir = null;
    protected ImageButton imgMais = null;
    protected ImageButton imgMenos = null;
    protected ImageButton imgSom1 = null;
    protected ImageButton imgSom2 = null;
    protected ImageButton imgSom3 = null;
    protected ImageButton imgSom4 = null;
    protected ImageButton imgSom5 = null;
    protected ImageButton imgDanca1 = null;
    protected ImageButton imgDanca2 = null;
    protected ImageButton imgDanca3 = null;
    protected ImageButton imgDanca4 = null;
    protected ImageButton imgDanca5 = null;

    protected Handler repeatUpdateHandler = new Handler();
    protected boolean mAutoIncrement = false;
    private boolean mAutoDecrement = false;
    private static final int REP_DELAY = 1500;
    private static final int REP_DELAY_DIR = 1100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    protected void atribuirBotoes() {

        imgFrente = findViewById(R.id.imgFrente);
        imgDireita = findViewById(R.id.imgDireita);
        imgAtras = findViewById(R.id.imgAtras);
        imgEsquerda = findViewById(R.id.imgEsquerda);
        imgGiroEsq = findViewById(R.id.imgGiroEsq);
        imgGiroDir = findViewById(R.id.imgGiroDir);
        imgMais = findViewById(R.id.imgMais);
        imgMenos = findViewById(R.id.imgMenos);
        imgSom1 = findViewById(R.id.imgSom1);
        imgSom2 = findViewById(R.id.imgSom2);
        imgSom3 = findViewById(R.id.imgSom3);
        imgSom4 = findViewById(R.id.imgSom4);
        imgSom5 = findViewById(R.id.imgSom5);
        imgDanca1 = findViewById(R.id.imgDanca1);
        imgDanca2 = findViewById(R.id.imgDanca2);
        imgDanca3 = findViewById(R.id.imgDanca3);
        imgDanca4 = findViewById(R.id.imgDanca4);
        imgDanca5 = findViewById(R.id.imgDanca5);
    }

    protected class UpdaterFrente implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("W");
                repeatUpdateHandler.postDelayed(new UpdaterFrente(), REP_DELAY_DIR);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterFrente(), REP_DELAY_DIR);
            }
        }
    }

    protected class UpdaterDireita implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("D");
                repeatUpdateHandler.postDelayed(new UpdaterDireita(), REP_DELAY_DIR);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterDireita(), REP_DELAY_DIR);
            }
        }
    }

    protected class UpdaterAtras implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("S");
                repeatUpdateHandler.postDelayed(new UpdaterAtras(), REP_DELAY_DIR);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterAtras(), REP_DELAY_DIR);
            }
        }
    }

    protected class UpdaterEsquerda implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("A");
                repeatUpdateHandler.postDelayed(new UpdaterEsquerda(), REP_DELAY_DIR);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterEsquerda(), REP_DELAY_DIR);
            }
        }
    }

    protected class UpdaterGiroEsquerda implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("Q");
                repeatUpdateHandler.postDelayed(new UpdaterGiroEsquerda(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterGiroEsquerda(), REP_DELAY);
            }
        }
    }

    protected class UpdaterGiroDireita implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("E");
                repeatUpdateHandler.postDelayed(new UpdaterGiroDireita(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterGiroDireita(), REP_DELAY);
            }
        }
    }

    protected class UpdaterMais implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("M");
                repeatUpdateHandler.postDelayed(new UpdaterMais(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterMais(), REP_DELAY);
            }
        }
    }

    protected class UpdaterMenos implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("N");
                repeatUpdateHandler.postDelayed(new UpdaterMenos(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterMenos(), REP_DELAY);
            }
        }
    }

    protected class UpdaterSom1 implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("T");
                repeatUpdateHandler.postDelayed(new UpdaterSom1(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterSom1(), REP_DELAY);
            }
        }
    }

    protected class UpdaterSom2 implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("Y");
                repeatUpdateHandler.postDelayed(new UpdaterSom2(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterSom2(), REP_DELAY);
            }
        }
    }

    protected class UpdaterSom3 implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("U");
                repeatUpdateHandler.postDelayed(new UpdaterSom3(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterSom3(), REP_DELAY);
            }
        }
    }

    protected class UpdaterSom4 implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("I");
                repeatUpdateHandler.postDelayed(new UpdaterSom4(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterSom4(), REP_DELAY);
            }
        }
    }

    protected class UpdaterSom5 implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("O");
                repeatUpdateHandler.postDelayed(new UpdaterSom5(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterSom5(), REP_DELAY);
            }
        }
    }

    protected class UpdaterDanca1 implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("G");
                repeatUpdateHandler.postDelayed(new UpdaterDanca1(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterDanca1(), REP_DELAY);
            }
        }
    }

    protected class UpdaterDanca2 implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("H");
                repeatUpdateHandler.postDelayed(new UpdaterDanca2(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterDanca2(), REP_DELAY);
            }
        }
    }

    protected class UpdaterDanca3 implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("J");
                repeatUpdateHandler.postDelayed(new UpdaterDanca3(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterDanca3(), REP_DELAY);
            }
        }
    }

    protected class UpdaterDanca4 implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("K");
                repeatUpdateHandler.postDelayed(new UpdaterDanca4(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterDanca4(), REP_DELAY);
            }
        }
    }

    protected class UpdaterDanca5 implements Runnable {

        public void run() {

            if (mAutoIncrement) {

                enviarInformacao("L");
                repeatUpdateHandler.postDelayed(new UpdaterDanca5(), REP_DELAY);
            } else if (mAutoDecrement) {

                repeatUpdateHandler.postDelayed(new UpdaterDanca5(), REP_DELAY);
            }
        }
    }
}
