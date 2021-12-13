import wx
import TvDnes


class Panel1(wx.Panel):

    def __init__(self, parent, id):
        wx.Panel.__init__(self, parent, id)
        try:
            image_file = 'img.jpg'
            bmp1 = wx.Image(image_file,wx.BITMAP_TYPE_ANY).ConvertToBitmap()
            self.bitmap1 = wx.StaticBitmap(self, -1, bmp1, (0, 0))
            frame_title = "TV Schedule"
            parent.SetTitle(frame_title)
        except IOError:
            print
            "Image file %s not found" % image_file
            raise SystemExit

        self.button1 = wx.Button(self.bitmap1, label='Close',pos=(910, 710), size=(85, 35))
        self.Bind(wx.EVT_BUTTON, self.closeButton, self.button1)
        self.Bind(wx.EVT_CLOSE, self.closeWindow)
        panel = wx.Panel(self.bitmap1)
        box = wx.BoxSizer(wx.HORIZONTAL)
        LIST_AUTOSIZE = 201
        self.list = wx.ListCtrl(panel, -1, style=wx.LC_REPORT)
        self.list.InsertColumn(0, 'TV', width=LIST_AUTOSIZE)
        for item in TvDnes.list_tvChannels:
            self.list.InsertItem(0, item)
        self.list.InsertColumn(1, 'Now:', width=LIST_AUTOSIZE)
        for x in range(0,100):
            for index in range(len(TvDnes.list_tvSeries)):
                self.list.SetItem(x,1,TvDnes.list_tvSeries[index-x])
        self.list.InsertColumn(2, 'After', width=LIST_AUTOSIZE)
        self.list.InsertColumn(3, '', width=LIST_AUTOSIZE)
        self.list.InsertColumn(4, '', width=LIST_AUTOSIZE)
        box.Add(self.list, 1, wx.EXPAND)
        panel.SetSizer(box)
        panel.Fit()
        self.Centre()

    def closeButton(self,event):
        self.Close(True)
        frame1.Close()


    def closeWindow(self,event):
        self.Destroy()


app = wx.App(False)
frame1 = wx.Frame(None, -1,size=(1024, 800))
panel1 = Panel1(frame1, -1)
frame1.Show(True)
app.MainLoop()