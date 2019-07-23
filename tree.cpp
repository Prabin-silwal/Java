#include<iostream>
#include<conio.h>
using namespace std;
struct node{
	int data;
	node *left;
	node *right;
	node(int data)
	{
		this->data=data;
		left=right=NULL;
	}	
};
void preorder(node *root)
{
	if(root==NULL)
	return;

	
	cout<<root->data<<"||";
	preorder(root->left);
	preorder(root->right);

}
void postorder(node *root)
{
	if(root==NULL)
	return;
	postorder(root->left);
	postorder(root->right);
	cout<<root->data<<"||";
	
	
}
void inorder(node *root)
{
	if(root==NULL)
	return;
	inorder(root->left);
	cout<<root->data<<"||";
	inorder(root->right);
	
	
}

int main()
{
	struct node *root= new node(10);
	root->left=new node(8);
	root->right=new node(12);
	root->left->left=new node(4);
	root->left->right=new node (9);
	root->right->right=new node(15);
	root->right->left=new node(11);
	cout<<"\n preorder  :";
	preorder(root);
	cout<<"\n postorder::        ";
	postorder(root);
	cout<<"\n inorder:::                       ";
	inorder(root);
	
	
}
