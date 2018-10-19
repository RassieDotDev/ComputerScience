import numpy as np
from PIL import Image
from matplotlib import pyplot as plt



def WM(cipher, plaintext, covertext, watermark, size, R):
	cipher = np.fft.fft(cipher)
	plaintext  = np.fft.fft(plaintext)
	powerspec = np.absolute(cipher) * np.absolute(cipher)
	powerspec = np.fft.fft(powerspec)
	diffusion = np.fft.fft(cipher)
	for i in range(0, size):
		for j in range(0,size):
			for k in range(3):		
				temp = powerspec[i][j][k]
				if(temp==0):
					powerspec[i][j][k]=1
				else:
					powerspec[i][j] = powerspec[i][j][k]



	diffusion = np.multiply(cipher ,np.divide(plaintext,powerspec))

	diffusion = np.real(np.fft.ifft(diffusion))
	diffusion = np.divide(diffusion,np.max(diffusion))

	
	watermark = np.multiply(R,diffusion) + covertext

	watermark = np.divide(watermark,np.max(watermark))
	return watermark


def RECWM(cipher, watermark, covertext, plaintext, size):

	diffusion = np.subtract(watermark,covertext)

	cipher = np.fft.fft(cipher)
	diffusion = np.fft.fft(diffusion)

	
	plaintext = np.multiply(np.conj(cipher) , diffusion)


	plaintext = np.real(np.fft.ifft(plaintext))
	plaintext = np.divide(plaintext,np.max(plaintext))
	
	return plaintext
	
	
	
	
	
#READ IMAGE FILES
host = Image.open("ab.bmp")
watermark = Image.open("e_mc2.bmp")
noise = Image.open("wn.bmp")

#PROCESS THEM TO ARRAYS
listHost = np.array(host)
listWm = np.array(watermark)
listNoise = np.array(noise)	
wm = listWm


#SET SIZE AND RATIO
size = 200
R = 0.3


#WATERMARK IMAGE
wm = WM(listNoise, listWm, listHost, wm, size, R)

#DISPLAY IMAGE
plt.imshow(wm, interpolation='none')
plt.show()

#DECYPHER IMAGE
pt = RECWM(listNoise, listWm, wm, listHost, size)	

plt.imshow(pt, interpolation='none')
plt.show()

