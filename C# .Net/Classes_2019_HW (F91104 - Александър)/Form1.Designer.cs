namespace Classes_2019
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnExit = new System.Windows.Forms.Button();
            this.txtName = new System.Windows.Forms.TextBox();
            this.txtFamily = new System.Windows.Forms.TextBox();
            this.txtFacNumb = new System.Windows.Forms.TextBox();
            this.txtGrade = new System.Windows.Forms.TextBox();
            this.txtAge = new System.Windows.Forms.TextBox();
            this.txtProgram = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.btnStudent = new System.Windows.Forms.Button();
            this.btnNewStudent = new System.Windows.Forms.Button();
            this.btnShow = new System.Windows.Forms.Button();
            this.btnClear = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.panel1.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnExit
            // 
            this.btnExit.Location = new System.Drawing.Point(467, 373);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(85, 26);
            this.btnExit.TabIndex = 0;
            this.btnExit.Text = "Exit";
            this.btnExit.UseVisualStyleBackColor = true;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(97, 18);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(100, 20);
            this.txtName.TabIndex = 1;
            // 
            // txtFamily
            // 
            this.txtFamily.Location = new System.Drawing.Point(97, 80);
            this.txtFamily.Name = "txtFamily";
            this.txtFamily.Size = new System.Drawing.Size(100, 20);
            this.txtFamily.TabIndex = 2;
            // 
            // txtFacNumb
            // 
            this.txtFacNumb.Location = new System.Drawing.Point(97, 142);
            this.txtFacNumb.Name = "txtFacNumb";
            this.txtFacNumb.Size = new System.Drawing.Size(100, 20);
            this.txtFacNumb.TabIndex = 3;
            // 
            // txtGrade
            // 
            this.txtGrade.Location = new System.Drawing.Point(97, 204);
            this.txtGrade.Name = "txtGrade";
            this.txtGrade.Size = new System.Drawing.Size(100, 20);
            this.txtGrade.TabIndex = 4;
            // 
            // txtAge
            // 
            this.txtAge.Location = new System.Drawing.Point(97, 266);
            this.txtAge.Name = "txtAge";
            this.txtAge.Size = new System.Drawing.Size(100, 20);
            this.txtAge.TabIndex = 5;
            // 
            // txtProgram
            // 
            this.txtProgram.Location = new System.Drawing.Point(97, 328);
            this.txtProgram.Name = "txtProgram";
            this.txtProgram.Size = new System.Drawing.Size(100, 20);
            this.txtProgram.TabIndex = 6;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(9, 21);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(35, 13);
            this.label1.TabIndex = 7;
            this.label1.Text = "Name";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(9, 83);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(36, 13);
            this.label2.TabIndex = 8;
            this.label2.Text = "Family";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(9, 145);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(81, 13);
            this.label3.TabIndex = 9;
            this.label3.Text = "Faculty Number";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(9, 207);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(36, 13);
            this.label4.TabIndex = 10;
            this.label4.Text = "Grade";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(9, 269);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(26, 13);
            this.label5.TabIndex = 11;
            this.label5.Text = "Age";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(9, 331);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(46, 13);
            this.label6.TabIndex = 12;
            this.label6.Text = "Program";
            // 
            // btnStudent
            // 
            this.btnStudent.Location = new System.Drawing.Point(443, 42);
            this.btnStudent.Name = "btnStudent";
            this.btnStudent.Size = new System.Drawing.Size(108, 23);
            this.btnStudent.TabIndex = 13;
            this.btnStudent.Text = "class Student";
            this.btnStudent.UseVisualStyleBackColor = true;
            this.btnStudent.Click += new System.EventHandler(this.btnStudent_Click);
            // 
            // btnNewStudent
            // 
            this.btnNewStudent.Location = new System.Drawing.Point(443, 93);
            this.btnNewStudent.Name = "btnNewStudent";
            this.btnNewStudent.Size = new System.Drawing.Size(108, 23);
            this.btnNewStudent.TabIndex = 14;
            this.btnNewStudent.Text = "class New Student";
            this.btnNewStudent.UseVisualStyleBackColor = true;
            this.btnNewStudent.Click += new System.EventHandler(this.btnNewStudent_Click);
            // 
            // btnShow
            // 
            this.btnShow.Location = new System.Drawing.Point(443, 153);
            this.btnShow.Name = "btnShow";
            this.btnShow.Size = new System.Drawing.Size(108, 23);
            this.btnShow.TabIndex = 15;
            this.btnShow.Text = "Show";
            this.btnShow.UseVisualStyleBackColor = true;
            this.btnShow.Click += new System.EventHandler(this.btnShow_Click);
            // 
            // btnClear
            // 
            this.btnClear.Location = new System.Drawing.Point(467, 339);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(85, 26);
            this.btnClear.TabIndex = 16;
            this.btnClear.Text = "Clear";
            this.btnClear.UseVisualStyleBackColor = true;
            this.btnClear.Click += new System.EventHandler(this.btnClear_Click);
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.label6);
            this.panel1.Controls.Add(this.label5);
            this.panel1.Controls.Add(this.label4);
            this.panel1.Controls.Add(this.label3);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.txtProgram);
            this.panel1.Controls.Add(this.txtAge);
            this.panel1.Controls.Add(this.txtGrade);
            this.panel1.Controls.Add(this.txtFacNumb);
            this.panel1.Controls.Add(this.txtFamily);
            this.panel1.Controls.Add(this.txtName);
            this.panel1.Location = new System.Drawing.Point(14, 12);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(225, 361);
            this.panel1.TabIndex = 17;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(571, 407);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this.btnShow);
            this.Controls.Add(this.btnNewStudent);
            this.Controls.Add(this.btnStudent);
            this.Controls.Add(this.btnExit);
            this.Name = "Form1";
            this.Text = "Form1";
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.TextBox txtFamily;
        private System.Windows.Forms.TextBox txtFacNumb;
        private System.Windows.Forms.TextBox txtGrade;
        private System.Windows.Forms.TextBox txtAge;
        private System.Windows.Forms.TextBox txtProgram;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button btnStudent;
        private System.Windows.Forms.Button btnNewStudent;
        private System.Windows.Forms.Button btnShow;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.Panel panel1;
    }
}

