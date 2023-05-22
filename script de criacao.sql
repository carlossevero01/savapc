CREATE DATABASE sistematcc;

CREATE TABLE turma (
    turmaId int PRIMARY KEY auto_increment,
    nome Varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci,
    visibilidade TINYINT
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
    peso double,                    
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
    opRespostaId varchar(4)
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
    FOREIGN KEY (questionarioId) REFERENCES questionarioinicial(questionarioId),
    FOREIGN KEY (alunoId) REFERENCES aluno(alunoId),
    FOREIGN KEY (turmaId) REFERENCES turma(turmaId)
);
CREATE TABLE respostaTeste (
	respostaTesteId int PRIMARY KEY auto_increment,
	perguntaTesteId int,
	opRespostaId int,
	FOREIGN KEY (perguntaTesteId) REFERENCES perguntaTeste(perguntaTesteId) 
);

CREATE TABLE respostaQuestionario (
	respostaQuestionarioId int PRIMARY KEY auto_increment,
	perguntaQuestionarioId int,
	opRespostaId int,
	FOREIGN KEY (perguntaQuestionarioId) REFERENCES perguntaquestionario(perguntaQuestionarioId) 
);

CREATE TABLE alunoTurma (
    alunoId int,
    turmaId int,
    FOREIGN KEY (alunoId) REFERENCES aluno(alunoId),
    FOREIGN KEY (turmaId) REFERENCES turma(turmaId)
);

CREATE TABLE professorTurma (
    professorId int,
    turmaId int,
    FOREIGN KEY (professorId) REFERENCES professor(professorId),
    FOREIGN KEY (turmaId) REFERENCES turma(turmaId)
);

CREATE TABLE perguntaTeste_Teste (
    testeId int,
    perguntaTesteId int,
    FOREIGN KEY (testeId) REFERENCES teste(testeId),
    FOREIGN KEY (perguntaTesteId) REFERENCES perguntaTeste(perguntaTesteId)
);

CREATE TABLE habilidade_PerguntaTeste (
    habilidadeId int,
    perguntaTesteId int,
    FOREIGN KEY (habilidadeId) REFERENCES habilidade(habilidadeId),
    FOREIGN KEY (perguntaTesteId) REFERENCES perguntaTeste(perguntaTesteId)
);

CREATE TABLE alunoHabilidade (
    alunoId int,
    habilidadeId int,
    FOREIGN KEY (alunoId) REFERENCES aluno(alunoId),
    FOREIGN KEY (habilidadeId) REFERENCES habilidade(habilidadeId)
);

CREATE TABLE questPergunta (
    questionarioId int,
    perguntaQuestionarioId int,
    FOREIGN KEY (questionarioId) REFERENCES questionarioInicial(questionarioId),
    FOREIGN KEY (perguntaQuestionarioId) REFERENCES perguntaQuestionario(perguntaQuestionarioId)
);

CREATE TABLE opcaoResposta_PerguntaTeste (
    perguntaTesteId int,
    opcaoRespostaId int,
	FOREIGN KEY (perguntaTesteId) REFERENCES perguntaTeste(perguntaTesteId),
	FOREIGN KEY (opcaoRespostaId) REFERENCES opcaoResposta(opcaoRespostaId)
);

CREATE TABLE opcaoResposta_PerguntaQuestionario (
	perguntaQuestionarioId int,
    opcaoRespostaId int,
    FOREIGN KEY (perguntaQuestionarioId) REFERENCES perguntaquestionario(perguntaQuestionarioId),
    FOREIGN KEY (opcaoRespostaId) REFERENCES opcaoresposta(opcaoRespostaId)
);

CREATE TABLE regTestes_respostaTeste(
	regTestesId int ,
	respostaTesteId int,
	FOREIGN KEY (regTestesId) REFERENCES regTestes(regTestesId),
	FOREIGN KEY (respostaTesteId) REFERENCES respostaTeste(respostaTesteId)
);

CREATE TABLE regQuestionarios_RespostaQuestionario(
	regQuestionarioId int,
    respostaQuestionarioId int,
    FOREIGN KEY (regQuestionarioId) REFERENCES regquestionarios(regQuestionarioId),
	FOREIGN KEY (respostaQuestionarioId) REFERENCES respostaquestionario(respostaQuestionarioId)
);

CREATE TABLE testesturma (
	turmaId int,
	testeId int,
	FOREIGN KEY (turmaId) REFERENCES turma(turmaId),
	FOREIGN KEY (testeId) REFERENCES teste(testeId)
);

CREATE TABLE questionarioturmas (
	questionarioId int,
	turmaId int,
	FOREIGN KEY (questionarioId) REFERENCES questionarioInicial (questionarioId),
	FOREIGN KEY (turmaId) REFERENCES turma (turmaId)
);

CREATE TABLE projetoFinal (
	projetoId int PRIMARY KEY auto_increment,
	alunoId int,
	turmaId int,
	nota DOUBLE,
	FOREIGN KEY (alunoId) REFERENCES aluno (alunoId),
	FOREIGN KEY (turmaId) REFERENCES turma (turmaId)
);