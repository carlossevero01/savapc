INSERT INTO tb_role (role_id,name) values (1,"ROLE_ALUNO"); /*ROLE_ID:1 = ALUNO*/
INSERT INTO tb_role (role_id,name) values (2,"ROLE_PROF"); /*ROLE_ID:2 = PROF*/
INSERT INTO habilidade (nome) values ('Compreensao'); /*ID:1*/
INSERT INTO habilidade (nome) values ('Abstracao'); /*ID:2*/
INSERT INTO habilidade (nome) values ('Resolucao de problemas'); /*ID:3*/
INSERT INTO habilidade (nome) values ('Resolucao algoritmica'); /*ID:4*/
INSERT INTO habilidade (nome) values ('Avaliacao'); /*ID:5*/

INSERT INTO turma (turmaId,nome,visibilidade) values (1,"Turma TADS1/2023",true);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (1,"aluno","111","alunoTeste1","email1@gmail.com",55984,"2000-01-20","nao selecionado","alunoteste1","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,1);
INSERT INTO turma_usuario (usuarioId,turmaId) values (1,1);
INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (2,"aluno","222","alunoTeste2","email2@gmail.com",55985,"2000-01-21","nao selecionado","alunoteste2","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,2);
INSERT INTO turma_usuario (usuarioId,turmaId) values (2,1);
INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (3,"prof","333","profTeste1","email3@gmail.com",55986,"2000-01-22","nao selecionado","profteste1","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (2,3);
INSERT INTO turma_usuario (usuarioId,turmaId) values (3,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (10,"aluno","1000","alunoTeste10","email10@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste10","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,10);
INSERT INTO turma_usuario (usuarioId,turmaId) values (10,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (11,"aluno","1001","alunoTeste11","email11@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste11","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,11);
INSERT INTO turma_usuario (usuarioId,turmaId) values (11,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (12,"aluno","1012","alunoTeste12","email12@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste12","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,12);
INSERT INTO turma_usuario (usuarioId,turmaId) values (12,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (13,"aluno","1003","alunoTeste13","email13@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste13","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,13);
INSERT INTO turma_usuario (usuarioId,turmaId) values (13,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (14,"aluno","1004","alunoTeste14","email14@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste14","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,14);
INSERT INTO turma_usuario (usuarioId,turmaId) values (14,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (15,"aluno","1005","alunoTeste15","email15@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste15","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,15);
INSERT INTO turma_usuario (usuarioId,turmaId) values (15,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (16,"aluno","1006","alunoTeste16","email16@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste16","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,16);
INSERT INTO turma_usuario (usuarioId,turmaId) values (16,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (17,"aluno","1007","alunoTeste17","email17@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste17","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,17);
INSERT INTO turma_usuario (usuarioId,turmaId) values (17,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (18,"aluno","1008","alunoTeste18","email18@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste18","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,18);
INSERT INTO turma_usuario (usuarioId,turmaId) values (18,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (19,"aluno","1009","alunoTeste19","email19@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste19","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,19);
INSERT INTO turma_usuario (usuarioId,turmaId) values (19,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (20,"aluno","1020","alunoTeste20","email20@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste20","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,20);
INSERT INTO turma_usuario (usuarioId,turmaId) values (20,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (21,"aluno","1021","alunoTeste21","email21@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste21","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,21);
INSERT INTO turma_usuario (usuarioId,turmaId) values (21,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (22,"aluno","1022","alunoTeste22","email22@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste22","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,22);
INSERT INTO turma_usuario (usuarioId,turmaId) values (22,1);

INSERT INTO usuario (usuarioId,tipo,identificador,nome,email,telefone,dataNascimento,img,username,password) 
values (23,"aluno","1023","alunoTeste23","email23@gmail.com",55999,"2000-01-20","nao selecionado","alunoteste23","$2a$12$dv/6XzTyFska76E8DyXGOuVKyvrPNJ34rJsEsfzX5X2ubFNRyNIAe");
INSERT INTO tb_users_roles (role_id,usuarioId) values (1,23);
INSERT INTO turma_usuario (usuarioId,turmaId) values (23,1);

INSERT INTO teste (testeId,nome,visibilidade,disponibilidade) values (1,"pre-teste",true,"2023-10-10 00:00:00");
INSERT INTO testesturma (turmaId,testeId) values (1,1);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido) values (1,"Bob, o castor"," Bob, o castor, só diz a verdade na segunda, quarta  
e sexta-feira e sempre mente em todos os outros dias da semana. Hoje ele diz: “ Amanhã vou dizer a verdade.","Que dia é?");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (1,1);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (1,"VF","Não entendi",true);
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
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (10,"VF","Não entendi a questão",true);
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
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (12,"VF","Não entendi a questão",true);
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
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (16,"VF","Não entendi a questão",true);	
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
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (23,"VF","Não entendi a questão",true);
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
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (28,"VF","Não entendi a questão",true);
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
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (34,"VF","Não entendi a questão",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (35,"VF","B",false);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (7,31);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (7,32);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (7,33);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (7,34);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (7,35);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,7);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (2,7);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,7);

INSERT INTO teste (testeId,nome,visibilidade,disponibilidade) values (2,"teste 2",true,"2023-11-10 00:00:00");
INSERT INTO testesturma (turmaId,testeId) values (1,2);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (8,"Relógio Quebrado/ Reloj Roto","(BR) Um relógio digital exibe quatro dígitos. Cada dígito
é mostrado usando sete segmentos que podem estar
ligados ou desligados, conforme a figura abaixo.
(UY) Un reloj digital muestra cuatro dígitos. Cada dígito
se muestra usando siete segmentos que pueden
estar prendidos o apagados, según la figura
siguiente: 
","Se o relógio quebrou e estava exibindo a hora acima,
qual das seguintes opções pode ser a hora real?","test2quest1.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (2,8);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (36,"VF","A",false);					
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (37,"VF","B",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (38,"VF","C",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (39,"VF","D",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (40,"VF","Não entendi a questão / no entendí la pregunta",true);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (8,36);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (8,37);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (8,38);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (8,39);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (8,40);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (2,8);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,8);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (5,8);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (9,"Labirinto/Laberinto","(BR) Um carro robótico usa uma regra simples para
atravessar um labirinto:
Vire à direita sempre que possível.
A imagem dá um exemplo de como o robô
conduziria através de um labirinto.
(UY) Un coche robótico utiliza una regla simple para
atravesar un laberinto:
Gire a la derecha siempre que sea posible.
La imagen presenta un ejemplo de cómo el robot
conduciría a través de un laberinto. 
","Em quantos dos seguintes labirintos o carro alcançará o ponto vermelho se usar este sistema?
","test2quest2.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (2,9);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (41,"VF","0",false);					
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (42,"VF","1",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (43,"VF","2",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (44,"VF","3",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (45,"VF","4",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (46,"VF","Não entendi a questão / no entendí la pregunta",true);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (9,41);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (9,42);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (9,43);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (9,44);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (9,45);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (9,46);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,9);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (4,9);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (5,9);

INSERT INTO teste (testeId,nome,visibilidade,disponibilidade) values (3,"teste 3",true,"2023-11-20 00:00:00");
INSERT INTO testesturma (turmaId,testeId) values (1,3);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (10,"Interface-1","(BR) Vamos relembrar o cálculo de uma regra de três simples: 
(UY) Recordemos la forma de calcular una regla de tres simple:
20 – 52
44 – X
X = (44*52) / 20
(UY) Considerando que el APP debe calcular y mostrar el resultado de una regla de tres, a partir de
los números propuestos por el usuario. Considere la interfaz para responder las cuestiones.
(BR) Considerando que o APP deve calcular e mostrar o resultado de uma regra de três, a
partir dos números fornecidos pelo usuário. Considere a interface para responder as
questões.","Considerando que o APP deve calcular e mostrar o resultado de uma regra de três, a
partir dos números fornecidos pelo usuário. A interface esta correta e é sucifiente para resolver o problema?","test3quest1.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (3,10);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (47,"VF","Sim/Sí",false);					-- CONFERIR A RESPOSTA CERTA COM A PROF
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (48,"VF","Não/No",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (49,"VF","Não entendi a questão / no entendí la pregunta",true);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (10,47);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (10,48);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (10,49);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,10);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,10);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (4,10);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (5,10);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (11,"Interface-2","(BR) Considerando
os valores de entrada 2, 4 e 5.  
(UY) Considerando los valores de entrada 2, 4 y 5. ¿Este código es correcto?",
"Este código acima está correto?","test3quest2.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (3,11);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (50,"VF","Sim/Sí",false);					-- CONFERIR A RESPOSTA CERTA COM A PROF
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (51,"VF","Não/No",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (52,"VF","Não entendi a questão / no entendí la pregunta",true);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (11,50);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (11,51);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (11,52);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,11);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,11);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (4,11);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (5,11);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido) values (12,"Interface-3","(BR) Qual o valor a ser mostrado no
TextBoxResultado?  
(UY) ¿Cuál es el valor que aparecerá en TextBoxResultado?",
" ");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (3,12);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (53,"VF","0",false);					-- CONFERIR A RESPOSTA CERTA COM A PROF
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (54,"VF","1",false);					-- CONFERIR VALORES PARA ASOPÇÕES RESPOSTAS
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (55,"VF","2",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (56,"VF","3",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (57,"VF","Não entendi a questão / no entendí la pregunta",true);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (12,53);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (12,54);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (12,55);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (12,56);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (12,57);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,12);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (5,12);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (13,"Interface-4","(BR)  Marque a alternativa correta: trecho de código que funcionará com
quaisquer valores digitados  
(UY) Marque la alternativa correcta: parte del código que funcionará con cualquier valor
ingresado. ",
" ","test3quest4.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (3,13);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (58,"VF","A",false);					-- CONFERIR A RESPOSTA CERTA COM A PROF
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (59,"VF","B",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (60,"VF","C",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (61,"VF","D)Nenhuma / Ninguna",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (62,"VF","E)Não entendi a questão / no entendí la pregunta",true);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (13,58);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (13,59);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (13,60);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (13,61);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (13,62);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,13);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,13);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (4,13);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (5,13);

INSERT INTO teste (testeId,nome,visibilidade,disponibilidade) values (4,"pós teste",true,"2023-11-30 00:00:00");
INSERT INTO testesturma (turmaId,testeId) values (1,4);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (14,"posteste-Interface",
"Você foi convidado a desenvolver este APP para calcular o IMC e mostrar o valor do IMC resultante e sua classificação. 
Explicação: IMC é a sigla para Índice de Massa Corporal que serve para avaliar o peso do indivíduo em relação à sua altura e assim indicar se está dentro do peso ideal, acima ou abaixo do peso desejado. Estar dentro do peso certo é importante porque estar acima ou abaixo do peso influencia na saúde, aumentando o risco de doenças como desnutrição quando se está abaixo do peso, e AVC e infarto, quando se está acima do peso. O cálculo do IMC deve ser feito usando a seguinte fórmula matemática: IMC = Peso (Kg) / Altura(m)²",
"Baseado na explicação anterior, responda as questões 01, 02,03 e 04. Marque somente uma alternativa. A interface (tela) está totalmente acordo com a descrição do problema? ","test4quest1.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (4,14);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (63,"VF","A) Não entendi a questão",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (64,"VF","B) Sim",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (65,"VF","C) Não",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (66,"VF","D) Em partes",true);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (14,63);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (14,64);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (14,65);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (14,66);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,14);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (2,14);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido) values (15,"posteste-Tabela"," ",
"A tabela 01 apresenta dados que são importantes para a programação do APP?");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (4,15);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (67,"VF","A) Não entendi a questão",true);       
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (68,"VF","B) Sim",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (69,"VF","C) Não",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (70,"VF","D) Em partes",true);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (15,67);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (15,68);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (15,69);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (15,70);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,15);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (2,15);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,15);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido) values (16,"posteste-Botoes"," ",
"Na interface proposta, é possível remover os botões de Sexo (Mulher e Homem) sem alterar a funcionalidade do aplicativo? ");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (4,16);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (71,"VF","A) Não entendi a questão",true);       
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (72,"VF","B) Sim",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (73,"VF","C) Não",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (74,"VF","D) Em partes",true);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (16,71);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (16,72);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (16,73);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (16,74);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,16);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (2,16);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (3,16);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (4,16);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (5,16);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (17,"posteste-Formula"," ",
"A figura abaixo mostra a fórmula do IMC implementada e parte da implementação da Tabela para mostra o resultado ao usuário. Esta porção do código está totalmente correta? ","test4quest4.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (4,17);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (75,"VF","A) Não entendi a questão",true);       
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (76,"VF","B) Sim",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (77,"VF","C) Não",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (78,"VF","D) Em partes",false);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (17,75);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (17,76);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (17,77);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (17,78);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,17);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (2,17);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (4,17);

INSERT INTO perguntaTeste (perguntaTesteId,titulo,descricao,pedido,img) values (18,"posteste-Valor"," ",
"Qual o valor que será mostrado na interface no 'CampoDeTextoMostrarResultado' (variável valor), segundo a figura abaixo?","test4quest5.png");
INSERT INTO perguntaTeste_teste (testeId, perguntaTesteId) values (4,18);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (79,"VF","A) Não entendi a questão",true);       
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (80,"VF","B) 70",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (81,"VF","C) 80",false);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (82,"VF","D) 90",false);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (18,79);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (18,80);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (18,81);
INSERT INTO opcaoresposta_perguntateste (perguntaTesteId,opcaoRespostaId) values (18,82);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (1,18);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (4,18);
INSERT INTO habilidade_perguntateste (habilidadeId,perguntaTesteId) values (5,18);

INSERT INTO questionarioinicial (questionarioId,disponibilidade,nome,visibilidade) values (1,"2023-10-30 00:00:00","Conhecendo você",true);
INSERT INTO questionarioturmas (questionarioId,turmaId) values (1,1);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (1,"Nacionalidade","Sua nacionalidade é? *","multipla escolha",true);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,1);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (83,"VF","Brasileiro(a)",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (84,"VF","Uruguaio(a)",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (85,"VF","Outro",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (1,83);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (1,84);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (1,85);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (2,"Idade","Qual sua idade? (0 - 100) *","dissertativa",true);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,2);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (3,"Sexo","Qual seu sexo? *","multipla escolha",true);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,3);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (86,"VF","Não selecionado",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (87,"VF","Feminino",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (88,"VF","Masculinho",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (89,"VF","Outro",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (3,86);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (3,87);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (3,88);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (3,89);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (4,"Etnia","Como você se considera?","multipla escolha",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,4);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (90,"VF","Não selecionado",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (91,"VF","Branco(a)",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (92,"VF","Negro(a)",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (93,"VF","Pardo(a)/mulato(a)",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (94,"VF","Amarelo(a) (de origem oriental)",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (95,"VF","Indígena ou de origem indígena",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (4,90);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (4,91);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (4,92);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (4,93);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (4,94);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (4,95);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (5,"Trabalha","Você trabalha? *","multipla escolha",true);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,5);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (96,"VF","Sim",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (97,"VF","Não",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (5,96);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (5,97);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (6,"Salario","Se você respondeu que trabalha, seu salário contribui para a renda familiar?","multipla escolha",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,6);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (98,"VF","Sim",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (99,"VF","Não",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (6,98);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (6,99);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (7,"Carga Horária","Se você trabalha ou já trabalhou, qual é (ou foi) a carga horária aproximada de sua atividade remunerada? (Não contar estágio e bolsas de pesquisa.)","multipla escolha",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,7);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (100,"VF","Não selecionado",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (101,"VF","Não trabalho / nunca exerci atividade remunerada",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (102,"VF","Trabalho / trabalhei eventualmente",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (103,"VF","Trabalho / trabalhei até 20 horas semanais",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (104,"VF","Trabalho / trabalhei mais de 20 horas semanais e menos de 40 horas semanais",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (105,"VF","Trabalho / trabalhei em tempo integral – 40 horas semanais ou mais",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (7,100);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (7,101);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (7,102);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (7,103);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (7,104);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (7,105);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (8,"Método de ingresso","Seu ingresso no curso de graduação se deu por meio de políticas de ação afirmativa da instituição?","multipla escolha",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,8);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (106,"VF","Não selecionado",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (107,"VF","Sim, por meio de sistema de reserva de vagas com identificação étnico-racial (negros, pardos e indígenas)",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (108,"VF","Sim, por meio de sistema de reserva de vagas com recorte social (egresso de escola pública, renda, etc.) ",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (109,"VF","Sim, por sistema distinto dos anteriores",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (110,"VF","Não",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (8,106);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (8,107);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (8,108);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (8,109);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (8,110);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (9,"Familiar","Com quem você mora atualmente?","multipla escolha",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,9);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (111,"VF","Não selecionado",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (112,"VF","Com os pais e(ou) com outros parentes",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (113,"VF","Com o(a) esposo(a) e(ou) com o(s) filho(s)",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (114,"VF","Com amigos (compartilhando despesas ou de favor). Com colegas, em alojamento universitário",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (115,"VF","Sozinho(a)",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (9,111);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (9,112);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (9,113);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (9,114);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (9,115);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (10,"Quantidade na casa","Quantos membros de sua família moram com você?","multipla escolha",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,10);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (116,"VF","Não selecionado",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (117,"VF","Nenhum",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (118,"VF","Um ou dois",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (119,"VF","Três ou quatro",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (120,"VF","Cinco ou seis",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (121,"VF","Mais de seis",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (10,116);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (10,117);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (10,118);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (10,119);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (10,120);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (10,121);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (11,"Curso","Que tipo de curso de ensino médio você concluiu?","multipla escolha",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,11);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (122,"VF","Não selecionado",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (123,"VF","Comum ou de educação geral, no ensino regular",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (124,"VF","Profissionalizante técnico (IFSul, UTU, outros), no ensino regular",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (125,"VF","Liceo",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (126,"VF","Supletivo",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (127,"VF","Outro",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (11,122);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (11,123);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (11,124);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (11,125);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (11,126);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (11,127);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (12,"Programa","Você sabe programar?*","multipla escolha",true);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,12);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (128,"VF","Sim",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (129,"VF","Não",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (12,128);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (12,129);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (13,"Experiência na programação","Se respondeu SIM na pergunta anterior, me conte sua experiência!","dissertativa",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,13);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (14,"Algoritmo","O que é ALGORITMO?*","dissertativa",true);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,14);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (15,"Variaveis","O que são variáveis, comandos de condição e repetição? (se não souber deixe em branco)","dissertativa",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,15);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (16,"Interesse pessoal","Ao fazer um curso de programação, quais são seus interesses pessoais ou profissionais?*","dissertativa",true);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,16);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (17,"Expectativa","Qual sua expectativa com relação a este curso?*","dissertativa",true);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,17);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (18,"Alfabetização digital","Marque na escala, como você considera seu conhecimento com relação a alfabetização digital (AD é 'a aquisição de habilidades básicas para o uso de computadores e da Internet' (Portal da Educação) )","multipla escolha",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,18);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (130,"VF","Não selecionado",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (131,"VF","0",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (132,"VF","1",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (133,"VF","2",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (134,"VF","3",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (135,"VF","4",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (18,130);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (18,131);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (18,132);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (18,133);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (18,134);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (18,135);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (19,"Horas de estudo","Quantas horas por semana, aproximadamente, você dedica / dedicou aos estudos, excetuando as horas de aula?","multipla escolha",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,19);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (136,"VF","Não selecionado",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (137,"VF","Nenhuma, apenas assisto às aulas",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (138,"VF","Uma a duas",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (139,"VF","Três a cinco",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (140,"VF","Seis a oito",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (141,"VF","Mais de oito",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (19,136);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (19,137);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (19,138);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (19,139);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (19,140);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (19,141);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (20,"Lugar de estudo","Onde você mais utiliza o computador (ou tablet ) para estudar?","multipla escolha",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,20);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (142,"VF","Não selecionado",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (143,"VF","Casa",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (144,"VF","Trabalho",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (145,"VF","Escola",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (146,"VF","Não utilizo",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (20,142);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (20,143);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (20,144);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (20,145);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (20,146);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (21,"Dados móveis","Você possui dados móveis?*","multipla escolha",true);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,21);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (147,"VF","Sim",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (148,"VF","Não",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (21,147);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (21,148);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (22,"Utilização de internet","Quando utiliza a internet, o que mais usa?","multipla escolha",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,22);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (149,"VF","Não selecionado",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (150,"VF","Redes Sociais",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (151,"VF","Jogos",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (152,"VF","Estudos",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (153,"VF","Pesquisas em Geral",true);
INSERT INTO opcaoresposta (opcaoRespostaId,tipo,descricao,verdadeira) values (154,"VF","Não utilizo",true);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (22,149);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (22,150);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (22,151);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (22,152);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (22,153);
INSERT INTO opcaoresposta_perguntaquestionario (perguntaQuestionarioId,opcaoRespostaId) values (22,154);

INSERT INTO perguntaquestionario (perguntaQuestionarioId,titulo,descricao,tipo,obrigatorio) values (23,"Expectativa com a pesquisa","Qual sua expectativa com relação a este curso ( participação nesta pesquisa )?","dissertativa",false);
INSERT INTO questpergunta (questionarioId,perguntaQuestionarioId) values (1,23);