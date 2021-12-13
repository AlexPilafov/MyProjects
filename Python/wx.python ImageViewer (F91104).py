import wx
import imghdr
import os

from PIL import Image
from PIL import ImageFilter

class Example(wx.Frame):
    def __init__(self,*args,**kw):
        super(Example,self).__init__(*args,**kw)
        pnl = wx.Panel(self)
        self.pilImage = Image.open('poster.jpg')
        self.image = wx.Image(self.pilImage.size[0],self.pilImage.size[1])
        self.image.SetData(self.pilImage.convert("RGB").tobytes())
        self.bitmap = wx.Bitmap(self.image)
        self.img = wx.StaticBitmap(pnl, 0, self.bitmap, pos=(15,10))

        cbtn = wx.Button(pnl,label='Filter', pos=(600,35))
        filters = ['BLUR','CONTOUR','DETAIL','EDGE_ENHANCE','EDGE_ENHANCE_MORE','EMBOSS','FIND_EDGES','SMOOTH','SMOOTH_MORE','SHARPEN']
        self.combo = wx.ComboBox(pnl, choices=filters, pos=(600,10))
        cbtn.Bind(wx.EVT_BUTTON, self.OnFilter)

        ftype = self.pilImage.format
        fsize = self.pilImage.size
        fmode = self.pilImage.mode
        fname = self.pilImage.filename
        fbytesize = os.path.getsize('poster.jpg')
        filetype = wx.StaticText(pnl, label = "Format: " + ftype, pos=(600,130))
        filesize = wx.StaticText(pnl, label = "Picture sizes: " + str(fsize), pos=(600,90))
        filemode = wx.StaticText(pnl, label = "Mode: " + fmode, pos=(600,110))
        filename = wx.StaticText(pnl, label = "Name: " + fname, pos=(600,70))
        filebytesize = wx.StaticText(pnl, label = "Filesize: " + str(fbytesize) + " bytes", pos=(600,150))

        rbtn = wx.Button(pnl, label= "Rotate 90°", pos=(600, 170))
        rbtn.Bind(wx.EVT_BUTTON, self.Rotation)

        fbtn = wx.Button(pnl, label= "Flip Top-Bottom", pos=(600, 200))
        fbtn.Bind(wx.EVT_BUTTON, self.FlipTopBottom)

        f2btn = wx.Button(pnl, label= "Flip Left-Right", pos=(600, 230))
        f2btn.Bind(wx.EVT_BUTTON, self.FlipLeftRight)

        resizeparameters = wx.StaticText(pnl, label="Resizing parameters :", pos=(600,260))
        self.resizevalue1 = wx.TextCtrl(pnl, pos=(715,260))
        self.resizevalue2 = wx.TextCtrl(pnl, pos=(825,260))

        resizebtn = wx.Button(pnl,label="Resize", pos=(935,260))
        resizebtn.Bind(wx.EVT_BUTTON, self.Resize)

        closebtn = wx.Button(pnl, label= "Close", pos=(1000, 500))
        closebtn.Bind(wx.EVT_BUTTON, self.OnClose)

        savebtn = wx.Button(pnl, label= "Save", pos=(900, 500))
        savebtn.Bind(wx.EVT_BUTTON, self.Save)

        self.SetSize((1280,720))
        self.SetTitle('Image Viewer')
        self.Centre()
        self.Show(True)

    def OnFilter(self,e):
        val = self.combo.GetValue()
        out = self.pilImage.filter(getattr(ImageFilter, val))
        self.image.SetData(out.convert('RGB').tobytes())
        self.image.SetAlpha(out.convert('RGBA').tobytes()[3::4])
        self.bitmap = wx.Bitmap(self.image)
        self.img.SetBitmap(self.bitmap)
    
    def Rotation(self, e):
        out = self.pilImage.rotate(90)
        self.image.SetData(out.convert('RGB').tobytes())
        self.image.SetAlpha(out.convert('RGBA').tobytes()[3::4])
        self.bitmap = wx.Bitmap(self.image)
        self.img.SetBitmap(self.bitmap)

    def FlipTopBottom(self, e):
        out = self.pilImage.transpose(Image.FLIP_TOP_BOTTOM)
        self.image.SetData(out.convert('RGB').tobytes())
        self.image.SetAlpha(out.convert('RGBA').tobytes()[3::4])
        self.bitmap = wx.Bitmap(self.image)
        self.img.SetBitmap(self.bitmap)

    def FlipLeftRight(self, e):
        out = self.pilImage.transpose(Image.FLIP_LEFT_RIGHT)
        self.image.SetData(out.convert('RGB').tobytes())
        self.image.SetAlpha(out.convert('RGBA').tobytes()[3::4])
        self.bitmap = wx.Bitmap(self.image)
        self.img.SetBitmap(self.bitmap)

    def Resize(self, e):
        h = int(self.resizevalue1.GetValue())
        w = int(self.resizevalue2.GetValue())
        out = self.pilImage.resize((w,h))
        out.show()
        #даваше ми line 87 , ValueError: Invalid data buffer size. и не можах да го направя да излиза вътре

    def OnClose(self, e):
        self.Close()

    def Save(self, e):
        self.image.SaveFile("Newfile.jpg")

ex = wx.App()
Example(None)
ex.MainLoop()