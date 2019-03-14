# q2a.py
# Name:
# Section:

# TODO: fill sv_iterative
# m is a matrix represented by a 2D list of integers. e.g. m = [[3, 0, 2, 18],[-1, 1, 3, 4],[-2, -3, 18, 7]]
# This function returns the Special Value of the matrix passed in.
def sv_iterative(m):
  # your code here
  # row, columns
  rows = len(m)
  columns = len(m[0])

  # for loop
  for i in range(rows-1, -1, -1):
    for j in range(columns-1, -1, -1):
      if i < rows - 1:
        m[i][j] += m[i+1][j]
      if j < columns - 1:
        m[i][j] += m[i][j+1]
  print(m)
  return m[0][0] # change