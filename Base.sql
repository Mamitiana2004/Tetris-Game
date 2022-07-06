create database tetris;
\c tetris
create table partie(
	idpartie BIGSERIAL PRIMARY KEY,
	scorePlayer1 int,
	scorePlayer2 int
);
create table score(
	scorePlayer1 int,
	scorePlayer2 int
);