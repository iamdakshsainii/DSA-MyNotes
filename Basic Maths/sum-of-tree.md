

// if binary is containing 2 then return false otherwise if we goes to 0 then true
   while (n > 0) {
            if (n % 3 == 2) return false; // If we get a 2, it's not a valid sum of powers of three
            n /= 3;
        }
        return true;
