
function findSum(basesum, max){

  //start at 1
  for(var i=1; i<max; i++){
    if(i%3==0 || i%5==0){
      basesum += i;
    }
  }
  return basesum;
}

console.log(findSum(0,10));
console.log(findSum(0,1000));

