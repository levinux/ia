from InfoGain import Gain
from BuildFromTraining import loadFromFile

gain = {}

##################################################
print("Cargando ejemplos de entrenamiento...")
S = loadFromFile("training_examples.txt")
Attributes = list(S[0])
##################################################
###
##################################################
print("Calculando ganancia de informacion...")

for A in Attributes[:-1]:
  gain[A] = Gain(S, A)

for k, v in gain.items():
  print("{} tiene un gain de {}".format(k, v))
##################################################
#print("Atributos: {}".format(Attributes))
#print("Ganancias: {}".format(gain))
