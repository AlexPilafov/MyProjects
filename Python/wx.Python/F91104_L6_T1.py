import wx

class BMICalculator(wx.Frame):
	def __init__(self, parent, id):
		wx.Frame.__init__(self, parent, id, "BMI Calculator", (600, 800))
		self.panel = wx.Panel(self)
		self.Centre()
		self.info_text = wx.StaticText(self.panel, -1, "Enter your height and weight and press compute to see your BMI.", (20, 15))
		self.label_text = wx.StaticText(self.panel, -1, "BMI: ", (20, 50))
		self.result_text = wx.StaticText(self.panel, -1, "", (46, 50))
		self.static_text_height = wx.StaticText(self.panel, -1, "Height:", (20, 90))
		self.height = wx.SpinCtrlDouble(self.panel, -1, pos = (65, 87), size = (60, -1), min = 0, max = 300)
		self.static_text_height_extra = wx.StaticText(self.panel, -1, "(cm)", (130, 90))
		self.static_text_weight = wx.StaticText(self.panel, -1, "Weight:", (20, 130))
		self.weight = wx.SpinCtrlDouble(self.panel, -1, pos = (65, 127), size = (60, -1), min = 0, max = 300)
		self.static_text_weight_extra = wx.StaticText(self.panel, -1, "(kg)", (130, 130))
		self.button_calculate = wx.Button(self.panel, label = "Calculate", pos = (40, 170), size = (60, -1))
		self.button_calculate.Bind(wx.EVT_BUTTON, self.onCalculate)
		self.button_cancel = wx.Button(self.panel, label = "Close", pos = (285, 170), size = (60, -1))
		self.button_cancel.Bind(wx.EVT_BUTTON, self.onClose)
	
	def onCalculate(self, event):
		if (self.calculate_BMI(self.height.GetValue(), self.weight.GetValue()) == None):
			self.result_text
		else:
			self.result_text.SetLabel(str(self.calculate_BMI(self.height.GetValue(), self.weight.GetValue())))
	
	def onClose(self, event):
		self.Close(True)
	
	def calculate_BMI(self, height, weight):
		height_m = float(height) / 100
		BMI = weight / (height_m * height_m)
		return BMI
	
def main():
	app = wx.App()
	frame = BMICalculator(None, -1)
	frame.Show()
	app.MainLoop()
	
if __name__ == "__main__":
	main()