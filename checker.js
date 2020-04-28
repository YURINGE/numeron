
var firstclick = Boolean("true");
var target;

function calc() {

    if (firstclick) {
        target = randomGenerate();
        firstclick = Boolean(false)
        console.log(target[0],target[1],target[2])
    }

    //入力値取得
    var inputnum = document.getElementById("num").value;
    if (String(inputnum).length != 3){
      alert("3桁で入力してください。");
      exit;
    }
    var result = checkNum(inputnum, target);

    var child = document.createElement('p');
    child.className = "result-item";
    child.innerHTML = inputnum + " : " + result.eatCount + " eat, " + result.biteCount + " bite";

    var parent = document.getElementById("calc-result");
    parent.appendChild(child);

}

function randomGenerate(){
    const nums = []
    for (i=0; i < 10; i++){
        nums.push(Boolean(false))
    }

    const randomNum = []
    for (i=0; i < 3;){
      const num = Math.floor(Math.random() * 10)
      if (!nums[num]){
        randomNum.push(num)
        nums[num] = Boolean(true)
        i++
      }
    }
    return randomNum
}

function checkNum(input, target) {
    var eatCount = 0;
    var biteCount = 0;
    const inputNums = input.split('')
    inputNums.forEach(num => {
      num = Number(num)
    });
    for (i=0; i < 3; i++){
      for (k=0; k < 3; k++){
        if (i == k){
          if (inputNums[i] == target[k]){
            eatCount++
          }
        } else {
          if (inputNums[i] == target[k]){
            biteCount++
          }
        }
      }
    }

    var res = {"eatCount": eatCount, "biteCount": biteCount};

    return res;
}