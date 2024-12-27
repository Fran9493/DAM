import pytest
from principal import Calculadora

def test_suma():
    calculadora = Calculadora()
    assert calculadora.sumar(2,3) == 5