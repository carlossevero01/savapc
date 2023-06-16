INSERT INTO habilidade (nome) values ('Compreensao'); /*ID:1*/
INSERT INTO habilidade (nome) values ('Abstracao'); /*ID:2*/
INSERT INTO habilidade (nome) values ('Resolucao de problemas'); /*ID:3*/
INSERT INTO habilidade (nome) values ('Resolucao algoritmica'); /*ID:4*/
INSERT INTO habilidade (nome) values ('Avaliacao'); /*ID:5*/

INSERT INTO turma (turmaId,nome,visibilidade,pesoTestes) values (1,"Turma TADS1/2023",true,7);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (1,"aluno","111","alunoTeste1","email1@gmail.com",55984,"2000-01-20","nao selecionado","alunoteste1","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO turma_usuario (usuarioId,turmaId) values (1,1);
INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (2,"aluno","222","alunoTeste2","email2@gmail.com",55985,"2000-01-21","nao selecionado","alunoteste2","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO turma_usuario (usuarioId,turmaId) values (2,1);
INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (3,"prof","333","profTeste1","email3@gmail.com",55986,"2000-01-22","nao selecionado","profteste1","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO turma_usuario (usuarioId,turmaId) values (3,1);


INSERT INTO teste (testeId,nome,visibilidade,disponibilidade) values (1,"pre-teste",true,"2023-10-10 00:00:00");
INSERT INTO testesturma (turmaId,testeId) values (1,1);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido) values (1,"Bob, o castor"," Bob, o castor, só diz a verdade na segunda, quarta  
e sexta-feira e sempre mente em todos os outros dias da semana. Hoje ele diz: “ Amanhã vou dizer a verdade.","Que dia é?");
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

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (2,"Cinco garrafas","Um castor coloca cinco garrafas em uma mesa.
 Ele as coloca de modo que cada garrafa apareça um pedaço. Ele coloca a primeira garrafa na 
parte de trás da mesa e cada garrafa subsequente na frente da anterior.","Em que ordem as garrafas foram colocadas conforme mostrado na figura?","test1quest2.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (1,2);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (6,"VF","D B C A E",false);	
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (7,"VF","D C E B A",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (8,"VF","E D C B A",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (9,"VF","E C D A B",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (10,"VF","não entendi a questão",false);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (2,6);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (2,7);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (2,8);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (2,9);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (2,10);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (2,2);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,2);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (3,"Sequencia de lances","Depois da 
escola, os jovens castores costumam brincar juntos. Para evitar brigas sobre onde jogar, eles jogam um dado normal 
de seis lados. A decisão é encontrada de acordo com esta regra:","Qual sequência de lances mandará os jovens castores para o campo esportivo?","test1quest3.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (1,3);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (11,"VF","B",false);	
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (12,"VF","não entendi a questão",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (13,"VF","D",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (14,"VF","A",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (15,"VF","C",true);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (3,11);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (3,12);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (3,13);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (3,14);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (3,15);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,3);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,3);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (4,3);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (4,"Fluxograma","Na escola, os 
pequenos castores fazem cálculos complicados usando fluxograma. Eles começam com um número no começo! e siga as 
instruções:","Ao começar com o número 18, qual é o número quando terminar?(se não entendeu a pergunta, responda 'não entendi a questão')","test1quest4.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (1,4);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (16,"VF","não entendi a questão",true);	
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (17,"VF","1",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (18,"VF","2",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (19,"VF","3",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (20,"VF","4",false);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (4,16);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (4,17);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (4,18);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (4,19);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (4,20);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,4);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,4);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (4,4);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (5,4);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (5,"Codificação de mensagens","O 
castor Alex e o castora Betty enviam mensagens uns aos outros usando a seguinte sequência de transformações em 
cada palavra.","Por exemplo, a palavra 'BEAVER' é transformada para 'WBFCSF'.
A castora Betty recebe a mensagem codificada 'PMGEP' do castor Alex.
O que Alex deseja dizer?","test1quest5.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (1,5);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (21,"VF","RIVER",true);	
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (22,"VF","KNOCK",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (23,"VF","não entendi a questão",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (24,"VF","FLOOD",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (25,"VF","LODGE",false);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (5,21);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (5,22);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (5,23);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (5,24);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (5,25);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,5);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,5);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (4,5);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (5,5);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (6,"Aldeias","O Sr.Beaver 
tem 4 amigos que moram em aldeias diferentes e planeja visitar um desses amigos todas as tardes. 
Inicialmente, todas as setas apontam para a estrada esquerda. Ao passar pelo cruzamento, o Sr.Beaver 
mudava a seta para a direção oposta. Por exemplo, no dia 1, o Sr. Beaver pega a estrada à esquerda na primeira 
interseção, pega a estrada à esquerda na segunda interseção e chega a Aldeia W. No dia 2, o Sr. Beaver vira à 
direita na primeira interseção, então à esquerda no segundo cruzamento e chega a Aldeia Y."
,"¿Qué pueblo visitará el señor Beaver el día 30?","test1quest6.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (1,6);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (26,"VF","Aldeia Y",true);	
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (27,"VF","Aldeia  X",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (28,"VF","não entendi a questão",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (29,"VF","Aldeia Z",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (30,"VF","Aldeia W",false);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (6,26);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (6,27);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (6,28);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (6,29);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (6,30);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,6);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (2,6);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,6);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (7,"Móbile","Um móbile é uma obra de arte pendurada no teto. Você deve se lembrar de um pendurado no teto em seu quarto. Um móbile consiste em paus e figuras. 
Cada vara tem alguns pontos para os quais as figuras ou outras varas podem ser anexadas. Além disso, cada vara tem um ponto de suspensão, a partir do qual é presa a uma vara mais acima (ou ao teto). 
O seguinte exemplo de móbile pode ser descrito usando estes números e parenteses:
(-3 (-1 1) (1 1)) (2 3)"
,"Quais dos seguintes dispositivos móveis podem ser construídos usando estas instruções:
(-3 (-1 4) (2 (-1 1) (1 1))) (2 (-1 6) (2 3)) ","test1quest7.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (1,7);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (31,"VF","C",false);	
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (32,"VF","A",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (33,"VF","D",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (34,"VF","não entendi a questão",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (35,"VF","B",false);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (7,31);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (7,32);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (7,33);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (7,34);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (7,35);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,7);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (2,7);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,7);