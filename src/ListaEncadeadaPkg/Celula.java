package ListaEncadeadaPkg;

public class Celula {
	private Contato valor;
	private Celula proximo;

	public Contato getValor() {
		return valor;
	}

	public void setValor(Contato valor) {
		this.valor = valor;
	}

	public Celula getProximo() {
		return proximo;
	}

	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}

}
