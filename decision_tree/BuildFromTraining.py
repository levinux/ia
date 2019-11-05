def loadFromFile(filename):
  archivo = open(filename, "rt")
  training = []

  for linea in archivo:
    values = linea.strip().split(",")
    s = {
      "outlook":     values[0],
      "temperature": values[1],
      "humidity":    values[2],
      "wind":        values[3],
      "playtennis":  values[4]
    }
    training.append(s)
  return training

