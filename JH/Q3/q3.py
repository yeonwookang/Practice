# q3.py
# Name:
# Section: 

from itertools import combinations

# TODO: fill ttsum
# nums is a list of integers (e.g. [3, 0, 1, 0, -1, -2, 0])
# t is the target sum (e.g. 0)
def ttsum(nums, t):
  # your code here
  result = []
  indexs = [i for i in range(len(nums))]

  combinations2 = list(combinations(indexs, 2))
  for i in range(len(combinations2)):
    n = nums[combinations2[i][0]]
    m = nums[combinations2[i][1]]
    if (n+m) == t:
      result.append([combinations2[i][0], combinations2[i][1]])

  combinations3 = list(combinations(indexs, 3))
  for i in range(len(combinations3)):
    n = nums[combinations3[i][0]]
    m = nums[combinations3[i][1]]
    l = nums[combinations3[i][2]]
    if (n+m+l) == t:
      result.append([combinations3[i][0], combinations3[i][1], combinations3[i][2]])

  return result