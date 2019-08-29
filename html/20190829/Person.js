function Person(){
    // this.name = 'test1';
    // this.age = 18;
    // this.print = function(){
    //     console.log(this.name + "   " + this.age);
    // }
    this.aaa = 888;
}

 Person.prototype.name='test1';
 Person.prototype.age=18;
 Person.prototype.print=function(){console.log(this.name + "   " + this.age);};

function Teacher(subject){
    Person.call(this); //调用Person的构造函数
    this.subject = subject;
}
//打断Teacher默认的原型链，设置其原型链为Person.prototype
Teacher.prototype = Object.create(Person.prototype);
Teacher.prototype.constructor = Teacher;
let teacher = new Teacher('aaa');
console.log(teacher);

