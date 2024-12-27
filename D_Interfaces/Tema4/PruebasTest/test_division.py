import pytest
from operaciones import Calculadora

def test_division():
    calculadora = Calculadora()
    assert calculadora.division(8, 2) == 4