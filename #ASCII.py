#ASCII

import PIL.Image


CHARS = ["@","#","S","%","?","*","+",";",":",",","."]

def resize(image, new_width=300):
    width, height = image.size
    ratio = height/ width
    new_height = int(new_width * ratio)
    resizedimag = image.resize((new_width, new_height))
    return(resizedimag)

def gray(image):
    grayscale = image.convert("L")
    return(grayscale)

def find_key(image):
    pixels = image.getdata()
    characters = "".join([CHARS[pixel//25] for pixel in pixels])
    return(characters)


def main(new_width = 300):
    path = input("Enter an image path:\n")

    try:
        image = PIL.Image.open(path)
    except:
        print(path, "is not a valid pathname image.")

    new_image_data = find_key(gray(resize(image)))

    pixel_count = len(new_image_data)
    new_image = "\n".join(new_image_data[i:(i+new_width)] for i in range(0, pixel_count, new_width))

    print(new_image)

    with open("ascii_image.txt","w") as f:
        f.write(new_image)


main()
