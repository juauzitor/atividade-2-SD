import xmlrpc.client

def main():
    # Endereço do servidor XML-RPC
    server_url = 'http://localhost:8000'
    # Criando o cliente XML-RPC
    server = xmlrpc.client.ServerProxy(server_url)

    try:
        questions = server.QuizHandler.getQuestions()
        respostas = []
        for question in questions:
            print("Pergunta:", question['pergunta'])
            for alternativas in question['respostas']:
                print("Alternativa: " + str(alternativas['alternativa']) + " " + alternativas['descricao'])
            respostas.append(int(input("Sua resposta: ")))

        acertos = server.QuizHandler.acertos(respostas)
        print(acertos)
    except Exception as e:
        print("Erro ao receber questões:", e)


if __name__ == "__main__":
    main()

