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
  return {bestA: bestV}

def id3(Examples, TargetA, Attributes):
  A = {}
  Root = ""
  if ExamplesArePos(Examples): return (Root, "+")
  if ExamplesAreNeg(Examples): return (Root, "-")
  if len(Attributes) == 0: return (Root, "=")
  ###

  ### Otherwise ###
  A = BestGainAttribute(Examples, Attributes)
  print(A)
  print(Attributes)
