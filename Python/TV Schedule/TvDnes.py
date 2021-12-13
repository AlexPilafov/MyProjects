from bs4 import BeautifulSoup as soup  # beautifulSoup = soup
from urllib.request import urlopen as uReq  # urlopen = uReq

page_url = "https://www.dnes.bg/tv.php"
getPage = uReq(page_url)
page_soup = soup(getPage.read(), "html.parser")
getPage.close()

tvChannels = page_soup.find_all(class_="tv_logo")
tvTimes = page_soup.find_all(class_="info")
tvSeries = page_soup.find_all(class_="ttl")

list_tvChannels = []
list_Times = []
list_tvSeries = []
seperator = ", "

for tvChannel in tvChannels:
    tvChannel = tvChannel.get_text()
    list_tvChannels.append(tvChannel)

for tvTime in tvTimes:
    tvTime = tvTime.get_text()
    list_Times.append(tvTime)

for tvSerie in tvSeries:
    tvSerie = tvSerie.get_text()
    list_tvSeries.append(tvSerie)

def converttostr(input_seq, seperator):
    final_str = seperator.join(input_seq)
    return final_str



print("---------------------------------------------")

print(tvChannels[0].get_text())
print(tvTimes[0].get_text() + " " + tvSeries[0].get_text())
print(tvTimes[1].get_text() + " - " + tvSeries[1].get_text())
print(tvTimes[2].get_text() + " - " + tvSeries[2].get_text())
print(tvTimes[3].get_text() + " - " + tvSeries[3].get_text())

print("---------------------------------------------")

print(tvChannels[1].get_text())
print(tvTimes[4].get_text() + " " + tvSeries[4].get_text())
print(tvTimes[5].get_text() + " - " + tvSeries[5].get_text())
print(tvTimes[6].get_text() + " - " + tvSeries[6].get_text())
print(tvTimes[7].get_text() + " - " + tvSeries[7].get_text())
print("---------------------------------------------")

print(tvChannels[47].get_text())  # до 47 което е Eurosport HD(48ми канал) 47x4(защото имаме по 4 времена на канал) = 188 затова времената започват от това число
print(tvTimes[188].get_text() + " " + tvSeries[188].get_text())  # понякога излизат по малко от 4 сериала наведнъж и числото се променя
print(tvTimes[189].get_text() + " - " + tvSeries[189].get_text())
print(tvTimes[190].get_text() + " - " + tvSeries[190].get_text())
print(tvTimes[191].get_text() + " - " + tvSeries[191].get_text())
print("---------------------------------------------")
print(list_tvChannels)
print(list_Times)
print(list_tvSeries)
print("---------------------------------------------")
