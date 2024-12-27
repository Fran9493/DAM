import pytest
from operaciones import Calculadora

def test_suma1():
    calculadora = Calculadora()
    assert calculadora.sumar(2, 5) == 7

def test_suma2():
    calculadora = Calculadora()
    assert calculadora.sumar(2.3, 5) == 7.0

