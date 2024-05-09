-- Criar a tabela de questões
CREATE TABLE IF NOT EXISTS questoes (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    pergunta TEXT NOT NULL
);


-- Criar a tabela de respostas
CREATE TABLE IF NOT EXISTS respostas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    questao_id INTEGER,
    alternativa INTEGER,
    descricao TEXT,
    correta INTEGER,
    FOREIGN KEY (questao_id) REFERENCES questoes (id)
);


-- Inserir questões
INSERT INTO questoes (pergunta) VALUES ('Qual destas linguagens é interpretada?');
INSERT INTO questoes (pergunta) VALUES ('Qual dos serviços abaixo tem como objetivo proporcionar uma conexão segura para acessar remotamente outro computador?');
INSERT INTO questoes (pergunta) VALUES ('O uso da manufatura discreta se apoia nas tecnologias da Indústria 4.0. Você consegue identificar qual delas mais impacta?');
INSERT INTO questoes (pergunta) VALUES ('Para que serve a algebra linear?');
INSERT INTO questoes (pergunta) VALUES ('A utilização de Sistemas Distribuídos (SD) é importante para a indústria porque permite atuar sobre uma planta de forma flexível e sem acoplamento. Existem tecnologias nas quais a utilização de SD está na base?');
INSERT INTO questoes (pergunta) VALUES ('Processadores RISC (Reduced Instruction Set Computer), ao contrário dos processadores CISC (Complex Instruction Set Computer), possuem instruções de tamanho variável para reduzir o número de instruções necessárias para realizar tarefas mais pesadas, levando a instruções menores e que gastam menos ciclos do processador. A afirmação anterior é verdadeira?');
INSERT INTO questoes (pergunta) VALUES ('É correto afirmar que aprendizagem de máquina possui grande relação com sinais e sistemas?');

-- Inserir respostas para cada questão
-- Questão 1
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (1, 1, 'Python', 1);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (1, 2, 'C', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (1, 3, 'Rust', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (1, 4, 'Go', 0);

-- Questão 2
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (2, 1, 'SSH', 1);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (2, 2, 'SMTP', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (2, 3, 'WEB', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (2, 4, 'IMAP', 0);

-- Questão 3
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (3, 1, 'Realidade Aumentada', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (3, 2, 'IOT', 1);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (3, 3, 'Robôs', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (3, 4, 'Internet', 0);

-- Questão 4
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (4, 1, 'Ir de Lauro de Freitas pra Pituba', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (4, 2, 'Não tem utilidade', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (4, 3, 'Trabalhar com sistemas matemáticos', 1);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (4, 4, 'Equação de 5º grau', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (4, 5, 'Funções exponenciais', 0);

-- Questão 5
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (5, 1, 'Computação em nuvem', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (5, 2, 'Computação de borda', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (5, 3, 'Todas as Alternativas', 1);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (5, 4, 'IOT', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (5, 5, 'Gêmeo Digital', 0);

-- Questão 6
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (6, 1, 'Sim', 0);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (6, 2, 'Não', 1);

-- Questão 7
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (7, 1, 'Sim', 1);
INSERT INTO respostas (questao_id, alternativa, descricao, correta) VALUES (7, 2, 'Não', 0);