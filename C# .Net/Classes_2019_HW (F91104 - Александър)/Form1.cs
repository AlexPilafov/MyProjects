using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Classes_2019
{
    public partial class Form1 : Form
    {
        Student student1;
        NewStudent student2;
        bool first, second;
        public Form1()
        {
            InitializeComponent();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnStudent_Click(object sender, EventArgs e)
        {
            student1 = new Student(txtName.Text, txtFamily.Text, txtProgram.Text);
            try
            {
                student1.Age = Convert.ToInt32(txtAge.Text);
                student1.FNumb = Convert.ToInt32(txtFacNumb.Text);
                student1.Grade = Convert.ToDouble(txtGrade.Text);
                MessageBox.Show(student1.ToString());
                student1.MyMessage();
                first = true;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "ERROR");
                first = false;
            }
        }

        private void btnNewStudent_Click(object sender, EventArgs e)
        {
            student2 = new NewStudent(txtName.Text, txtFamily.Text, txtProgram.Text);
            try
            {
                student2.Age = Convert.ToInt32(txtAge.Text);
                student2.FNumb = Convert.ToInt32(txtFacNumb.Text);
                student2.Grade = Convert.ToDouble(txtGrade.Text);
                MessageBox.Show(student2.ToString());
                student2.MyMessage();
                second = true;
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "ERROR");
                second = false;
            }
        }

        void ClearTextBoxes(Control con)
        //Обхождаме всички контроли, като проверяваме всеки дали е TextBox и дали не е празен.
        //Ако е празен, използваме метода Clear(), ако не е викаме рекурсивно отново функцията. 
        {
            foreach (Control c in con.Controls)
            {
                if (c is TextBox && c != null)
                    ((TextBox)c).Clear();
                else
                    ClearTextBoxes(c);
            }
        }

        private void btnClear_Click(object sender, EventArgs e)
        //Викаме рекурсивната функция ClearAllText с аргумент this, като this e формата в която се намира бутона.
        {
            ClearTextBoxes(this);
        }

        private void btnShow_Click(object sender, EventArgs e)
        {
            if(first && second)
            {
                string combine = student1.ToString();
                combine += Environment.NewLine;
                combine += "\r\n";
                combine += student2.ToString();
                MessageBox.Show(combine);
            }

        }
    }
    class Student
    {
        protected string stName;
        protected string stFamily, stProgram;
        protected int age;
        protected double grade;
        protected int facNumb;

        public override string ToString()
        {
            return stName +" "+ stFamily+ "\nFac.Number: "+ facNumb.ToString()
                + " Grade: " + grade.ToString()+"\nAge: " + age.ToString()+ ", Program: "+ stProgram;
        }
        public Student(string inName, string inFamily, string inProgram)
        {
            stName = inName;
            stFamily = inFamily;
            stProgram = inProgram;
        }
        public int Age
        {
            get { return age; }
            set { age = value; }
        }
        public int FNumb
        {
            get { return facNumb; }
            set { facNumb = value; }
        }
        public double Grade
        {
            get { return grade; }
            set
            {
                if (value > 2.0 && value < 6.0)
                    grade = value;
                else
                    grade = 0;
            }
        }
        public virtual void MyMessage()
        {
            MessageBox.Show("I am first class!");
        }
    }
    class NewStudent: Student
    {
        public NewStudent(string a, string b, string c)
            : base(a,b,c)
        {

        }
        public override void MyMessage()
        {
            MessageBox.Show("I am second class!");
        }
    }
}
