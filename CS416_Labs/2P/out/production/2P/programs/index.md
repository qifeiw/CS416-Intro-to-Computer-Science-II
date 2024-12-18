
## 00.prog

Halts immediately

## 01.prog

beep and print 7

## 02.prog

print 7 forever

## 03.prog

a = 6, print 6

## 04.prog

follow the jumps, overflow r0 and r1

## 06a.prog

if R0 == 0 print 6 else print 7 (prints 6)

## 06b.prog

if R0 == 0 print 6 else print 7 (prints 7)

## 07.prog

print 0 1 2 3 4 5 6 ...

## 08.prog

prints the numbers from 12 to 1

## 09.prog

get the value of memory[14] increment it and print it

## 10.prog

*p = 7 (addr 12 is pointer to addr 15)

## 11.prog

print 7 + 7 + 7 + 7 ...

## 12.prog

beep by writing a beep instruction at address 11

## 13.prog

forever jump to address 13

## 14a.prog

if memory[14] - memory[15] == 0 then print 0, otherwise print 1 (prints 0)

## 14b.prog

if memory[14] - memory[15] == 0 then print 0, otherwise print 1 (prints 1)

## 15.prog

swap addr 14 and 15

## 17.prog

increment r1, add it to r0, check print it, on second run jump to end

## 18.prog

print each step of 3 * 4 (MEM[13] * MEM[14])

## 19.prog

swap memory[14] and memory[15] using only one register

## 20.prog

beep if 7 + 8 == 15

## 21.prog

print 8, 7 times

## 22.prog

self check if 3333 5555 and beep if R0 is not 0 or print 0 if everything is ok

## 23.prog

various memory access/updates

## 24.prog

print 0,2,4,6,8...

## 25.prog

print 14, 12, 10, ... 0

## 26.prog

print 3+4+5 (also the values are executed but ignored)

## 28.prog

print 9,8,7,6,5,4,3,2,1 using the load instruction itself to load 9 into r0

## 29.prog

instruction that replicates itself in the right positions in memory

## 30.prog

print 9

## 31.prog

beep if overflow 0-1(15) + (0-1)15 is not 14

## 32.prog

print 5,beep,9,beep,12,beep,14,beep,15,beep and stop, branchless; (5+0, 5+4, 5+4+3, 5+4+3+2, 5+4+3+2+1)

## 33.prog

print 7 and beep by using the argument of the print instruction

## 34.prog

print 7 6 5 4 3 2 1

## 35.prog

beep and execute 6 5 4 3 2 1 0, use same address(0) with multiple instructions

## 36.prog

print 7 7 then next turn beep print 8 beep

## 37.prog


## 38.prog

terminate after two loops executing 1 twice

## 40.prog

print 0, 1, 2, 3 ...

## 41.prog

## 44.prog

print override print 1

## 45.prog

if r0 == r1 beep twice otherwise beep once

## 46.prog

beep by overwriting the jump at start

## 47.prog

if mem[14] - mem[15] == 1: print 1, else beep

## 48.prog

beep how much is mem[14] / mem[15]

## 49.prog

check if mem[12,13,14,15] are 0, or undefined behavior

## 50.prog

overflow, mem[3] = 15 jump to 0, dec, 14 0 0

## 51.prog

overflow, print 15,14,13,13 ... 1

## 52.prog

print 14 because 15 + 15 is 14 with overflow

## 53.prog

print 0 as 1 + 15 is 0

## 54.prog

overflowing print 2,5,9,14,4,11,3,12,6 ...
