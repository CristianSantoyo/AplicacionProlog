porcentajeNota1(0.35).
porcentajeNota2(0.35).
porcentajeNota3(0.30).
porcentajeFallasPermitido(0.20).
numClasesporCredito(16).

acumulado1(A,B):- porcentajeNota1(X), B is X*A.
acumulado2(A,B):- porcentajeNota2(X), B is X*A.
acumulado3(A,B):- porcentajeNota3(X), B is X*A.

numTotalClases(A,B):- numClasesporCredito(X), B is X*A.

porcentajeFallas(N,F,B):- numTotalClases(N,X), B is F/X.

asistencia(N,F):-
    porcentajeFallas(N,F,P),
    porcentajeFallasPermitido(X),
    P =< X.

sumAcumulado(A,B,C,S):-
    acumulado1(A,X),
    acumulado2(B,Y),
    acumulado3(C,Z),
    S is X+Y+Z.

aprobado(N,F,A,B,C):-
    sumAcumulado(A,B,C,S),
    asistencia(N,F),
    S > 2.9.

