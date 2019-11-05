from Entropy import binEntropy as entropy

masterkey = "playtennis"

def countPN(training, key, pv="yes", nv="no"):
  pos = 0
  neg = 0

  for example in training:
    if example[key] == pv: pos = pos + 1
    elif example[key] == nv: neg = neg + 1

  return pos, neg

def Gain(S, A):
  Spos, Sneg = countPN(S, masterkey)
  S_entropy = entropy(Spos, Sneg)
  return S_entropy

