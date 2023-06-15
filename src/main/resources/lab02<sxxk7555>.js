//Name:Saurabh Kumar
//ID:1001827555
//Date Due- 7 March 2023
// 1.(5 points) Start with an array called inputtable. The array should have numbers between
// 1 and 10.
const inputtable = Array.from({ length: 10 }, (_, i) => i + 1); //an array called inputtable, which has numbers between 1 and 10
console.log(inputtable);//print the inputtable

// 2(30 points) Use inputtable from step 1 to create the following: -
//     a. Set of multiples of 5 between 1 and 51. Name it fiveTable, print the contents to the console
// b. Set of multiples of 13 between 1 and 131. Name it thirteenTable, print the contents to the console
// c. Set of squares of the numbers in inputtable. Name it squaresTable, print the contents to the console
//function which multiply and return multiple of 5
function fiveTable() {
    return inputtable.map(e => e * 5);
}
//print the above function to console
console.log(fiveTable());

//function which multiply and return multiple of 32

function thirteenTable() {
    return inputtable.map(e => e * 13);
}
//print the above function to console
console.log(thirteenTable());

//function which return square of each number
function squaresTable() {
    return inputtable.map(e => e * e);
}
//print the above function to console
console.log(squaresTable());

// 3.(10 points) Get (and then print) the odd multiples of 5 between 1 and 100. 5, 15, ...

//function which  return array of numbers from 1 to 100
function arrayOfHunderedDigits() {
    return Array.from({ length: 100 }, (_, i) => i + 1);
}

//function which filters the odd multiples of 5 from the oddMulFive array
function oddMulFive() {
    return arrayOfHunderedDigits().filter(element => element % 5 == 0 && element % 2 != 0);
}
//print the above function to console
console.log(oddMulFive());

// 4.(20 points) Get (and then print) the sum of even multiples of 7 between 1 and 100.

//function which filters the odd multiples of 7 from the oddMulSeven array
function oddMulSeven() {
    return arrayOfHunderedDigits().filter(element => element % 7 == 0 && element % 2 == 0).reduce((sum, a) => sum + a, 0);
}
//print the above function to console
console.log(oddMulSeven());

// 5.(15 points) Use currying to rewrite the function below:
// function which calculates the volume of a cylinder with radius r and height h
function cylinder_volume(r) {
    return function(h) {
        return 3.14 * r * r * h;
    }
}
//prints the above function to console
console.log(cylinder_volume(5)(10));
console.log(cylinder_volume(5)(17));
console.log(cylinder_volume(5)(11));

// 6.  (15 points) Use the following code to take advantage of closures to wrap content with
//     HTML tags, specifically show an HTML table consisting of a table row that has at least
// one table cell/element. You can use the console to output your results.
    makeTag = function(beginTag, endTag){
    return function(textcontent){
        return beginTag +textcontent +endTag;
    }
}

console.log(makeTag('<', '>')('table'));
console.log(makeTag('<', '>')('tr'));
console.log(makeTag('<', '>')('th'));
console.log(makeTag('', '')('Firstname'));
console.log(makeTag('</', '>')('th'));
console.log(makeTag('<', '>')('th'));
console.log(makeTag('', '')('ID'));
console.log(makeTag('</', '>')('th'));
console.log(makeTag('<', '>')('th'));
console.log(makeTag('', '')('course'));
console.log(makeTag('</', '>')('th'));
console.log(makeTag('</', '>')('tr'));
console.log(makeTag('<', '>')('tr'));
console.log(makeTag('<', '>')('th'));
console.log(makeTag('', '')('Saurabh'));
console.log(makeTag('</', '>')('th'));
console.log(makeTag('<', '>')('th'));
console.log(makeTag('', '')('10012827555'));
console.log(makeTag('</', '>')('th'));
console.log(makeTag('<', '>')('th'));
console.log(makeTag('', '')('CS'));
console.log(makeTag('</', '>')('th'));
console.log(makeTag('</', '>')('tr'));
console.log(makeTag('</', '>')('table'));

// 7. (10 points) Do the ‘generic’ version of questions 3 and 4, meaning the target
// multiple must not be hard coded; hint: we studied closures and currying. This means you
// should be able to use the same code to handle multiple scenarios, for example: first odd
// multiples of 11 and then even multiples of 3 (still in the range 1 to 100). Your code
// should allow the grader to combine a chosen multiple along with the choice of odd / even
// without writing any code.

// This function returns an array of 100 random integers between 1 and 1000.
function arrayOfHundredDigits() {
    return Array.from({length: 100}, () => Math.floor(Math.random() * 1000) + 1);
}

// it takes two parameter a number and a string
function generic(num, type) {
    // verifies if the type parameter is 'odd', and filters the array of random integers to return only odd numbers that are divisible by the given number.
    if (type.toLowerCase() == 'odd') {
        return arrayOfHundredDigits().filter(element => element % num == 0 && element % 2 != 0);
    }
    // verifies if the type parameter is 'even', and filters the array of random integers to return only even numbers that are divisible by the given number.
    else if (type.toLowerCase() == 'even') {
        return arrayOfHundredDigits().filter(element => element % num == 0 && element % 2 == 0);
    }
}

//prints the above function
console.log(generic(11, 'ODD'));
console.log(generic(3, 'EVEN'));

//references: https://www.w3schools.com/js/default.asp

