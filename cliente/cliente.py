import xmlrpc.client

def main():
    # Endereço do servidor XML-RPC
    server_url = 'http://localhost:8000'
    # Criando o cliente XML-RPC
    server = xmlrpc.client.ServerProxy(server_url)
    opcao = int(input("Digite 1 se deseja jogar ou 2 se deseja ver o ranking: "))
    if opcao == 1:
        try:
            print("---------------------")
            print()
            nome = input("Qual seu nome: ")
            print("---------------------")
            print()
            questions = server.QuizHandler.getQuestions()
            respostas = []
            for question in questions:
                print("Pergunta:", question['pergunta'])
                for alternativas in question['respostas']:
                    print("Alternativa: " + str(alternativas['alternativa']) + " " + alternativas['descricao'])
                respostas.append(int(input("Sua resposta: ")))
                print()
            acertos = server.QuizHandler.acertos(nome, respostas)
            print(acertos)
        except Exception as e:
            print("Erro ao receber questões:", e)
    else:
        try:
            print("---------------------")
            print()
            ranking = server.QuizHandler.getRanking()
            idx = 1
            for jogador in ranking:
                print("Lugar: "+ str(idx) +"° |" + "jogador: " + jogador['nome'] + "| acertou: " + str(jogador['acertos']) + " Questões")
                idx +=1
        except Exception as e:
            print("Erro ao receber ranking", e)

if __name__ == "__main__":
    main()

