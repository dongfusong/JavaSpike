
// 1. 重复 --- 

重复的代码的位置！！

// 模板方法模式
class C{
public:
	void func1(){

	}
	void func2(){

	}
	virtual void toXXX(){

	}
	void func(){
		int cout = 0;
		toXXX();
		output(cout);
	}
};


class B : public C{
public:
	void toXXX(){
		count += aa();
	}
};

class D : public C{
public:

	void toXXX(){
		count += bb();
		toServer(count);
		xxx();
	}
};



// 如何解决大函数问题？

// 提取函数？

class Node{
public:
	Node(string name):name(name){

	}
	
	bool canReach(vector<Node*> path, string dstName){		
		for (int i = 0; i < path.size(); i++){
			if (path[i] == this){
				return false;
			}
		}
		if (dstName == name){
			return true;
		}
		return neighbors.canReach(dstName);
	}
private:
	string name;
};

// ------------职责单一， 面向接口的
// 在同一个层次上编程
class Node{
public:
	Node(string name):name(name){

	}
	bool hasTraced(std::vector<Node*> path){
		for (int i = 0; i < path.size(); i++){
			if (path[i] == this){
				return true;
			}
		}
		return false;
	}

	bool matchSelf(string name){
		return this->name == name;
	}

	bool canReach(vector<Node*> path, string dstName){		
		if (hasTraced(path)){
			return false;
		}
		if (matchSelf(dstName)){
			return true;
		}
		return neighbors.canReach(dstName);
	}
private:
	string name;
};


//问题： 一旦发现，vector性能不好，需要改为list，怎么改？
// 1. 硬改
// 2. 重构


// 类的职责不单一


class Path{
public:
	bool hasTraced(Node* node){
		for (int i = 0; i < path.size(); i++){
			if (path[i] == node){
				return true;
			}
		}
		return false;
	}
private:
	std::vector<Node*> path
};

class Node{
public:
	Node(string name):name(name){

	}

	bool matchSelf(string name){
		return this->name == name;
	}

	bool canReach(Path* path, string dstName){		
		if (path->hasTraced(this)){
			return false;
		}
		if (matchSelf(dstName)){
			return true;
		}
		return neighbors.canReach(dstName);
	}
private:
	string name;
};


// 函数的所属


// tell do not ask 
class A{
public:
	void func(){
		nameId += c->excute(nameId, name, msg);
		// ...
	}
	int func1(){
		// name = c->getName();
		// id = c->id();
		// return name + id + nameId;
		return c->getxx(nameId);
	}
private:
	C* c;
	int nameId;
	string name;
	Messge msg;
};

// 提取函数,过多的参数

class Doer{
	void func(){
		int a, int b, int c, int d; // 20个
		// ....
		func1(a,b,c,d,f...);//10个  parameter
	}

	void func1(int a, int b, int c, int d, int e, int f){

	}	
};


class Doer{
	struct A{
		int a;
		int b;
		int c;
	};

	struct B{
	 int d;
	 int e;
	 int f
	};


	void func(){
		int a, int b, int c, int d; // 20个
		// ....
		A aa;
		B bb;
		func1(a, bb, h);//10个  parameter
	}

	void func1(A aa, B bb, int h){
		int a = aa->a;
		int b = aa->b;
		int d = bb->d;
		int e = bb->e;
		int value =  a + b - d;
		//...

	}
};



class A{
	private:
		Msg msg;
		int a;
		int b;
		int c;
		void func(int value1, int value2){
			return msg.send(a + b + c + value1 + value2);
		}
	};

class B{
	 int d;
	 int e;
	 int f
	 void func(int value){
	 	return d / e + value;
	 }
};

class Doer{
	void func(){
		int a, int b, int c, int d; // 20个
		// ....
		A aa(msg);
		B bb;
		func1(a, bb, h);//10个  parameter
	}

	void func1(A aa, B bb, int h){
		aa.func(3, 5);
		bb.func(m);

	}
};




// 破坏封装性

class D{
public:
	void func(){
		c->getH()->doSomething();
		c->getH()->doSomething1();
		c->getH()->doSomething1(value);
	}
private:
	C* c;
};




///////////////////////////


class D{
public:
	void func(){
		c->doxx();
	}
private:
	C* c;
};


class C{
public:
	void doxx(){

		h->doSomething(value);
		h->doSomething1(valu2);
		h->doSomething1(value);
	}
private:
	H* h;
	int value;
	int value2;
};


// 是否有必要重构？
// 1. 为什么没有问题还要重构？
// --------- 分离关注点 / 解耦合 ------ 具体实现

// 2. 扩展性的重构，有用吗？？



推荐书籍：
《重构》
《重构手册》
《重构到模式》





