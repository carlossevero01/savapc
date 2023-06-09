CREATE DATABASE sistematcc;

CREATE TABLE turma (
    turmaId int PRIMARY KEY auto_increment,
    nome Varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    visibilidade TINYINT,
    pesoTestes double
);

CREATE TABLE aluno (
    alunoId int PRIMARY KEY auto_increment,
    matricula Varchar(30),
    nome Varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    email Varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    username varchar(100),
    senha varchar(100)
);

CREATE TABLE professor (
    professorId int PRIMARY KEY auto_increment,
    nome Varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
	email VARCHAR(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci          
);

CREATE TABLE teste (                    
    visibilidade Boolean,
    testeId int PRIMARY KEY auto_increment,
    disponibilidade Datetime,
    nome varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci
);
CREATE TABLE perguntaTeste (
    perguntaTesteId int PRIMARY KEY auto_increment,
    titulo varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    descricao longtext CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    opRespostaId varchar(4),
    img varchar(200)
);
CREATE TABLE opcaoResposta (
    opcaoRespostaId int PRIMARY KEY auto_increment,
    tipo varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    descricao varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    verdadeira boolean
);

CREATE TABLE questionarioInicial (
    questionarioId int PRIMARY KEY auto_increment,
    disponibilidade datetime,
    nome varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    visibilidade boolean
);
CREATE TABLE perguntaQuestionario (
    perguntaQuestionarioId int PRIMARY KEY auto_increment,
    titulo varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    descricao varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    tipo varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    opRespostaId varchar(4),
    resposta varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci
);

CREATE TABLE habilidade (
    habilidadeId int PRIMARY KEY auto_increment,
    nome Varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci
);

CREATE TABLE regTestes (
    regTestesId int PRIMARY KEY auto_increment,
    testeId int,
    alunoId int,
    turmaId int,
    FOREIGN KEY (testeId) REFERENCES teste(testeId),
    FOREIGN KEY (alunoId) REFERENCES aluno(alunoId),
    FOREIGN KEY (turmaId) REFERENCES turma(turmaId)
);

CREATE TABLE regQuestionarios (
    regQuestionarioId int PRIMARY KEY auto_increment,
    questionarioId int,
    alunoId int,
    turmaId int,
    FOREIGN KEY (questionarioId) REFERENCES questionarioinicial(questionarioId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (alunoId) REFERENCES aluno(alunoId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (turmaId) REFERENCES turma(turmaId) ON DELETE CASCADE ON UPDATE CASCADE 
);
CREATE TABLE respostaTeste (
	respostaTesteId int PRIMARY KEY auto_increment,
	perguntaTesteId int,
	opRespostaId int,
	FOREIGN KEY (perguntaTesteId) REFERENCES perguntaTeste(perguntaTesteId) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE respostaQuestionario (
	respostaQuestionarioId int PRIMARY KEY auto_increment,
	perguntaQuestionarioId int,
	opRespostaId int,
    tipo varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    resposta varchar(500) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
	FOREIGN KEY (perguntaQuestionarioId) REFERENCES perguntaquestionario(perguntaQuestionarioId) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE alunoTurma (
    alunoId int,
    turmaId int,
    FOREIGN KEY (alunoId) REFERENCES aluno(alunoId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (turmaId) REFERENCES turma(turmaId) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE professorTurma (
    professorId int,
    turmaId int,
    FOREIGN KEY (professorId) REFERENCES professor(professorId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (turmaId) REFERENCES turma(turmaId) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE perguntaTeste_Teste (
    testeId int,
    perguntaTesteId int,
    FOREIGN KEY (testeId) REFERENCES teste(testeId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (perguntaTesteId) REFERENCES perguntaTeste(perguntaTesteId) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE habilidade_PerguntaTeste (
    habilidadeId int,
    perguntaTesteId int,
    FOREIGN KEY (habilidadeId) REFERENCES habilidade(habilidadeId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (perguntaTesteId) REFERENCES perguntaTeste(perguntaTesteId) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE alunoHabilidade (
    alunoId int,
    habilidadeId int,
    FOREIGN KEY (alunoId) REFERENCES aluno(alunoId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (habilidadeId) REFERENCES habilidade(habilidadeId) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE questPergunta (
    questionarioId int,
    perguntaQuestionarioId int,
    FOREIGN KEY (questionarioId) REFERENCES questionarioInicial(questionarioId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (perguntaQuestionarioId) REFERENCES perguntaQuestionario(perguntaQuestionarioId)  
);

CREATE TABLE opcaoResposta_PerguntaTeste (
    perguntaTesteId int,
    opcaoRespostaId int,
    FOREIGN KEY (perguntaTesteId) REFERENCES perguntaTeste(perguntaTesteId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (opcaoRespostaId) REFERENCES opcaoResposta(opcaoRespostaId)  
);

CREATE TABLE opcaoResposta_PerguntaQuestionario (
	perguntaQuestionarioId int,
    opcaoRespostaId int,
    FOREIGN KEY (perguntaQuestionarioId) REFERENCES perguntaquestionario(perguntaQuestionarioId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (opcaoRespostaId) REFERENCES opcaoresposta(opcaoRespostaId)
);

CREATE TABLE regTestes_respostaTeste(
	regTestesId int ,
	respostaTesteId int,
	FOREIGN KEY (regTestesId) REFERENCES regTestes(regTestesId) ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (respostaTesteId) REFERENCES respostaTeste(respostaTesteId) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE regQuestionarios_RespostaQuestionario(
	regQuestionarioId int,
    respostaQuestionarioId int,
    FOREIGN KEY (regQuestionarioId) REFERENCES regquestionarios(regQuestionarioId) ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (respostaQuestionarioId) REFERENCES respostaquestionario(respostaQuestionarioId) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE testesturma (
	turmaId int,
	testeId int,
	FOREIGN KEY (turmaId) REFERENCES turma(turmaId) ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (testeId) REFERENCES teste(testeId) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE questionarioturmas (
	questionarioId int,
	turmaId int,
	FOREIGN KEY (questionarioId) REFERENCES questionarioInicial (questionarioId) ON DELETE CASCADE ON UPDATE CASCADE, 
	FOREIGN KEY (turmaId) REFERENCES turma (turmaId) ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE notas (
	notaId int PRIMARY KEY auto_increment,
	alunoId int,
	turmaId int,
    nPerguntasCorretas int,
    nPerguntas int,
    h1 int,
    h2 int,
    h3 int,
    h4 int,
    h5 int,
	notaProjetoFinal DOUBLE,
    pesoTestes DOUBLE,
	notaTestes DOUBLE,
	notaFinal DOUBLE,
	recomendacao VARCHAR(100),
	FOREIGN KEY (alunoId) REFERENCES aluno(alunoId) ON DELETE CASCADE ON UPDATE CASCADE ,
	FOREIGN KEY (turmaId) REFERENCES turma(turmaId) ON DELETE CASCADE ON UPDATE CASCADE 
);
CREATE TABLE correcoesAluno (
    correcaoId int PRIMARY KEY auto_increment,
    alunoId int,
    turmaId int,
    testeId int,
    perguntaTesteId int,
    opcaoRespostaId int,
    acertou boolean,
    FOREIGN KEY (alunoId) REFERENCES aluno(alunoId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (turmaId) REFERENCES turma(turmaId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (testeId) REFERENCES teste(testeId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (perguntaTesteId) REFERENCES perguntaTeste(perguntaTesteId) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (opcaoRespostaId) REFERENCES opcaoResposta(opcaoRespostaId) ON DELETE CASCADE ON UPDATE CASCADE 
);
CREATE TABLE testes_nota (
	notaId int,
    testeId int,
    foreign key (notaId) REFERENCES notas(notaId) on update cascade on delete cascade,
    foreign key (testeId) REFERENCES teste(testeId) on update cascade on delete cascade
);
