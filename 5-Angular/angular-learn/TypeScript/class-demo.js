export class Gender {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }

    display() {
        console.log("id=" + this.id + "; name=" + this.name);
    }
}

var male = new Gender(1, "Male");
male.display();

var female = new Gender(2, "Female");
female.display();
