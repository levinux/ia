from math import log2 as log

def isSomeoneZero(p, n):
  if p == 0 or n == 0:
    return True
  return False

def binEntropy(p, n):
  if isSomeoneZero(p, n): return 0
  if p == n: return 1

  t = p + n
  pos = p / t
  neg = n / t
  entropy = -pos * log(pos) - neg * log(neg)
  return entropy
