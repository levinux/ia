# Archivo vacio por el momento MUAHAHAHAHA

def ExamplesArePos(Examples):
  pass

def ExamplesAreNeg(Examples):
  pass

def id3(Examples, TargetA, Attributes):
  Root = ""
  if ExamplesArePos(Examples): return (Root, "+")
  if ExamplesAreNeg(Examples): return (Root, "-")
  if len(Attributes) == 0: return (Root, "=")
  ###

  ### Otherwise ###
  pass
