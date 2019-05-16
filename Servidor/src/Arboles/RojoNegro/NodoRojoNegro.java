package RojoNegro;

/* Class Node */
public class NodoRojoNegro<T extends Comparable> {
    private Color mColor = Color.RED;
    private T mKey = null;
    private NodoRojoNegro<T> mPadre = null;
    private NodoRojoNegro<T> mIzquierda = null;
    private NodoRojoNegro<T> mDerecha = null;

    public NodoRojoNegro(T mKey) {
        this.mKey = mKey;
    }

    public Color getColor() {
        return mColor;
    }

    public T getKey() {
        return mKey;
    }

    public NodoRojoNegro<T> getPadre() {
        return mPadre;
    }

    public NodoRojoNegro<T> getIzquierda() {
        return mIzquierda;
    }

    public NodoRojoNegro<T> getDerecha() {
        return mDerecha;
    }

    public void setColor(Color color) {
        mColor = color;
    }

    public void setPadre(NodoRojoNegro<T> padre) {
        mPadre = padre;
    }

    public void setIzquierda(NodoRojoNegro<T> izquierda) {
        mIzquierda = izquierda;
    }

    public void setDerecha(NodoRojoNegro<T> derecha) {
        mDerecha = derecha;
    }

    public void setKey(T key) {
        mKey = key;
    }
}
