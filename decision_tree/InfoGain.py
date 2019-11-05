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
  gain = 0
  values = {}
  Spos, Sneg = countPN(S, masterkey)
  S_entropy = entropy(Spos, Sneg)

  for s in S:
    value = s[A]
    if value not in values:
      values[value] = [0, 0]
    if s[masterkey] == "yes":
      values[value][0] = values[value][0] + 1
    elif s[masterkey] == "no":
      values[value][1] = values[value][1] + 1

  #return S_entropy
  return values
