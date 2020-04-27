porcentajeNota1(0.35).
porcentajeNota2(0.35).
porcentajeNota3(0.30).
porcentajeFallasPermitido(0.20).
numerodeClases(50).

acumulado1(A,B):- porcentajeNota1(X), B is X*A.
acumulado2(A,B):- porcentajeNota2(X), B is X*A.
acumulado3(A,B):- porcentajeNota3(X), B is X*A.

porcentajeFallas(A,B):- numerodeClases(X), B is A/X.

asistencia(A):-
    porcentajeFallas(A,P),
    porcentajeFallasPermitido(F),
    P =< F.

sumAcumulado(A,B,C,S):-
    acumulado1(A,X),
    acumulado2(B,Y),
    acumulado3(C,Z),
    S is X+Y+Z.

aprobado(F,A,B,C):-
    sumAcumulado(A,B,C,S),
    asistencia(F),
    S > 2.9.

