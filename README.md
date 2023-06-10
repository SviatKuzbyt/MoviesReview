# MoviesReview
An application for viewing information about various films and series from an internal database. Developed exclusively for demo purposes

## Features
- The program has 3 activities: `MainActivity`, `DetailActivity`, `SearchActivity`, `MoreListActivity`
- `MainActivity`: consists of a fragment and a bottom panel where you can switch between three fragments:
  - **Home** - there is a search field by clicking on which you will open the search activity as well as a click of movie lists (a couple of their elements and a button to open the activity list of movies with the entire list)
  - **Categories** - there are buttons that open the activity list of films with elements of a certain category
  - **Favorite** - displays your favorite items
- `DetailActivity` - clicking on the item with the list opens active information. It displays the name of the film, detailed information about it, description, zoonosis, as well as **buttons** for opening a link to view the film, add/remove from favorites
- `SearchActivity` - consists of EditText and list. By entering the name of the movie, all elements with the same name are selected from the database and filled in the list
- `MoreListActivity` lists movies by category
- Dark theme supported
- Uses different advanced approaches in the program: Room, ViewModel, kotlin coroutines, etc.

## Screanshots
| ![home](https://github.com/SviatKuzbyt/MoviesReview/blob/main/files%20for%20project/screenshots/home.jpg) | ![detail](https://github.com/SviatKuzbyt/MoviesReview/blob/main/files%20for%20project/screenshots/detail.jpg) | ![followed](https://github.com/SviatKuzbyt/MoviesReview/blob/main/files%20for%20project/screenshots/followed_dark.jpg) |
| - | - | - |

## How to install?
Go to the latest [Release](https://github.com/SviatKuzbyt/MoviesReview/releases/tag/1.0) and download and install the file `app-release.apk`
