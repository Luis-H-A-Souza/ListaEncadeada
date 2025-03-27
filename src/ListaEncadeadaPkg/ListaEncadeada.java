package ListaEncadeadaPkg;

import java.util.Scanner;

public class ListaEncadeada {
	private static int proximoId = 1;
	Scanner sc = new Scanner(System.in);

	private Celula primeiro;
	private Celula ultimo;
	private Celula posicaoAtual;

	public Celula getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(Celula primeiro) {
		this.primeiro = primeiro;
	}

	public Celula getUltimo() {
		return ultimo;
	}

	public void setUltimo(Celula ultimo) {
		this.ultimo = ultimo;
	}

	public Celula getPosicaoAtual() {
		return posicaoAtual;
	}

	public void setPosicaoAtual(Celula posicaoAtual) {
		this.posicaoAtual = posicaoAtual;
	}

	public void adicionar(Contato valor) {
		Celula celula = new Celula();
		celula.setValor(valor);

		if (primeiro == null && ultimo == null) {
			primeiro = celula;
			ultimo = celula;
		} else {
			ultimo.setProximo(celula);
			ultimo = celula;
		}
	}

	public void remover() {
		if (primeiro.getProximo() != null) {
			Celula celula = recuperarPenultimo(primeiro);
			ultimo = celula;
			ultimo.setProximo(null);
		} else {
			primeiro = ultimo = null;
		}
	}

	private Celula recuperarPenultimo(Celula celula) {
		if (celula.getProximo().equals(ultimo)) {
			return celula;
		}
		return recuperarPenultimo(celula.getProximo());
	}

	public boolean temProximo() {
		if (primeiro == null) {
			return false;
		} else if (posicaoAtual == null) {
			posicaoAtual = primeiro;
			return true;
		} else {
			boolean temProximo = posicaoAtual.getProximo() != null ? true : false;
			posicaoAtual = posicaoAtual.getProximo();
			return temProximo;
		}
	}

	public void addContato() {
		Contato contato = new Contato();

		contato.setId(proximoId);
		proximoId++;

		System.out.print("\nInforme a sua Matricula: ");
		String matricula = sc.next();
		contato.setMatricula(matricula);

		System.out.print("\nInforme o seu nome: ");
		String nome = sc.next();
		contato.setNome(nome);

		adicionar(contato);
		System.out.println("Contato adicionado com ID: " + contato.getId());
	}

	public void removerContato(int id) {
	    if (primeiro == null) {
	        System.out.println("Lista vazia!");
	        return;
	    }

	    if (primeiro.getValor().getId() == id) {
	        primeiro = primeiro.getProximo();
	        if (primeiro == null) {
	            ultimo = null;
	        }
	        System.out.println("Contato removido com sucesso!");
	        return;
	    }

	    Celula anterior = primeiro;
	    Celula atual = primeiro.getProximo();

	    while (atual != null) {
	        if (atual.getValor().getId() == id) {
	            anterior.setProximo(atual.getProximo());
	            if (atual == ultimo) {
	                ultimo = anterior;
	            }
	            System.out.println("Contato removido com sucesso!");
	            return;
	        }
	        anterior = atual;
	        atual = atual.getProximo();
	    }

	    System.out.println("Contato com ID " + id + " não encontrado!");
	}

	public Contato procurarId(int id) {
		Celula atual = primeiro;
		while (atual != null) {
			if (atual.getValor().getId().equals(id)) {
				return atual.getValor();
			}
			atual = atual.getProximo();
		}
		return null;
	}

	public void listarContatos() {
		if (primeiro == null) {
			System.out.println("Nenhum contato cadastrado!");
			return;
		}

		Celula atual = primeiro;
		while (atual != null) {
			Contato c = atual.getValor();
			System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome() + " | Matricula: " + c.getMatricula());
			atual = atual.getProximo();
		}
	}

	public void editarContato() {
		if (primeiro == null) {
			System.out.println("Lista de contatos vazia!");
			return;
		}

		System.out.print("Digite o ID do contato que deseja editar: ");
		int id = sc.nextInt();
		sc.nextLine();

		Celula celulaAtual = primeiro;
		boolean encontrado = false;

		while (celulaAtual != null) {
			if (celulaAtual.getValor().getId() == id) {
				encontrado = true;
				Contato contato = celulaAtual.getValor();

				System.out.println("\nEditando contato:");
				System.out.println("ID: " + contato.getId());
				System.out.println("Nome atual: " + contato.getNome());
				System.out.println("Matricula atual: " + contato.getMatricula());

				System.out.println("\nO que deseja editar?");
				System.out.println("1 - Nome");
				System.out.println("2 - Matricula");
				System.out.println("3 - Ambos");
				System.out.print("Opção: ");
				int opcao = sc.nextInt();
				sc.nextLine();

				switch (opcao) {
				case 1:
					System.out.print("Novo nome: ");
					contato.setNome(sc.nextLine());
					break;
				case 2:
					System.out.print("Nova matricula: ");
					contato.setMatricula(sc.nextLine());
					break;
				case 3:
					System.out.print("Novo nome: ");
					contato.setNome(sc.nextLine());
					System.out.print("Nova matricula: ");
					contato.setMatricula(sc.nextLine());
					break;
				default:
					System.out.println("Opção inválida!");
					return;
				}

				System.out.println("Contato atualizado com sucesso!");
				break;
			}
			celulaAtual = celulaAtual.getProximo();
		}

		if (!encontrado) {
			System.out.println("Contato com ID " + id + " não encontrado!");
		}
	}
}
