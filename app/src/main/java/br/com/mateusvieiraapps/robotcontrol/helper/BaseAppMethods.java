package br.com.mateusvieiraapps.robotcontrol.helper;

/**
 * Interface para definir alguns métodos padrões.
 *
 * @author Mateus V Machado
 * @version 1.0.0
 * @see br.com.mateusvieiraapps.robotcontrol.activity.MainActivity
 * @since 1.0.0
 */
public interface BaseAppMethods {

    void abrirIntent(Class<?> cls);

    void mostrarToast(CharSequence text);

    void mostrarToast(CharSequence text, int duration);
}
