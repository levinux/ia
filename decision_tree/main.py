from InfoGain import Gain
from BuildFromTraining import loadFromFile

gain = []

##################################################
print("Cargando ejemplos de entrenamiento...")
S = loadFromFile("training_examples.txt")
Attributes = list(S[0])
##################################################
###
##################################################
print("Calculando ganancia de informacion...")

#for A in Attributes:
#  gain.append(Gain(S, A))
print(Gain(S, "wind"))
##################################################
#print("Atributos: {}".format(Attributes))
#print("Ganancias: {}".format(gain))
