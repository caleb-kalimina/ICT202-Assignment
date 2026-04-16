# ICT 202 - Data Structures and Algorithms

**Student:** Caleb Mukelabai Kalimina
**Student ID:** 202401761
**Institution:** Mulungushi University

---

## Assignment: Infix to Postfix and Prefix Conversion

### Description

A Java program that converts infix expressions into both postfix and prefix notation using a stack-based algorithm (Shunting Yard Algorithm).

The program demonstrates:
- Stack data structure usage
- Operator precedence handling
- Bracket/parenthesis processing
- String manipulation and reversal techniques

---

### The Three Notations Explained

| Notation | Description | Example |
|----------|-------------|---------|
| Infix | Operator between operands | `A + B` |
| Postfix | Operator after operands | `A B +` |
| Prefix | Operator before operands | `+ A B` |

---

### Operator Precedence Used

| Operator | Precedence |
|----------|------------|
| `^` | 3 (highest) |
| `*` `/` | 2 |
| `+` `-` | 1 (lowest) |

---

### Workflow

**Infix to Postfix (Shunting Yard Algorithm):**
1. Read the expression left to right
2. Operand → add directly to output
3. `(` → push onto stack
4. Operator → pop all higher/equal precedence operators first, then push current
5. `)` → pop until `(` is found, discard both brackets
6. End of expression → pop all remaining operators from stack

**Infix to Prefix:**
1. Reverse the infix expression
2. Swap `(` with `)` and vice versa
3. Apply the postfix algorithm on the modified string
4. Reverse the result → this gives prefix

---

### How to Compile and Run

```bash
javac InfixConverter.java
java InfixConverter
```

---

### Sample Output

```
=======================================================
Infix                Postfix           Prefix         
=======================================================
A+B*C                ABC*+             +A*BC          
(A+B)*(C-D)          AB+CD-*           *+AB-CD        
A+B*C-D/E            ABC*+DE/-         -+A*BC/DE      
A*(B+C)-D^E          ABC+*DE^-         -*A+BC^DE      
=======================================================
```

---

### Files

| File | Description |
|------|-------------|
| `InfixConverter.java` | Main Java source code |
| `README.md` | This file |
