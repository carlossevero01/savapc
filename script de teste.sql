INSERT INTO habilidade (nome) values ('Compreensao'); /*ID:1*/
INSERT INTO habilidade (nome) values ('Abstracao'); /*ID:2*/
INSERT INTO habilidade (nome) values ('Resolucao de problemas'); /*ID:3*/
INSERT INTO habilidade (nome) values ('Resolucao algoritmica'); /*ID:4*/
INSERT INTO habilidade (nome) values ('Avaliacao'); /*ID:5*/

INSERT INTO aluno (alunoId,matricula,nome,idade,nacionalidade,username,senha) values (1,"5555","alunoTeste",22,"Brasileiro","alunoteste","1234");
INSERT INTO turma (turmaId,nome,visibilidade) values (1,"turmaTeste",true);
INSERT INTO alunoturma (alunoId,turmaId) values (1,1); 

INSERT INTO questionarioinicial (questionarioId,disponibilidade,nome,visibilidade) values (1,"2023-05-13 00:00:00","suas experiencias",true);
INSERT INTO questionarioturmas (questionarioId,turmaId) values (1,1);



INSERT INTO teste (testeId,nome,visibilidade,peso,disponibilidade) values (1,"pre-teste",true,7,"2023-05-13 00:00:00");
INSERT INTO testesturma (turmaId,testeId) values (1,1);
INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao) values (1,"Bob, o castor"," Bob, o castor, só diz a verdade na segunda, quarta  
e sexta-feira e sempre mente em todos os outros dias da semana. Hoje ele diz: “ Amanhã vou dizer a verdade. Que dia é? Escolha uma:");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (1,1);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (1,"VF","não entendi",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (2,"VF","Sábado",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (3,"VF","Quinta",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (4,"VF","Terça",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (5,"VF","Domingo",false);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (1,1);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (1,2);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (1,3);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (1,4);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (1,5);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,1);


