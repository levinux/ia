from InfoGain import Gain

# Vars aqui...
arbol = {}

def ExamplesArePos(Examples):
  pass

def ExamplesAreNeg(Examples):
  pass

def BestGainAttribute(S, Attrs):
  bestA = ""
  bestV = 0
  for A in Attrs:
    g = Gain(S, A)
    if g > bestV:
      bestV = g
      bestA = A
  Attrs.remove(bestA)
  return (bestA, bestV)

def valuesOfA(Examples, Attribute):
  valuesInA = []
  for example in Examples:
    valueOfA = example[Attribute]
    if valueOfA not in valuesInA:
      valuesInA.append(valueOfA)
  return valuesInA

def id3(Examples, TargetA, Attributes):
  A = {}
  Root = ""
  if ExamplesArePos(Examples): return (Root, "+")
  if ExamplesAreNeg(Examples): return (Root, "-")
  if len(Attributes) == 0: return (Root, "=")
  ###

  ### Otherwise ###
  A = BestGainAttribute(Examples, Attributes)
  arbol[A[0]] = {}
  valuesInA = valuesOfA(Examples, A[0])
  examplesV = []
  for value in valuesInA:
    for i in range(0, len(Examples)):
      if Examples[i][A[0]] == value:
        examplesV.append(Examples[i])
    id3(examplesV, TargetA, Attributes)
