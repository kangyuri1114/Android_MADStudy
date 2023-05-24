package com.example.book_search_app.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.book_search_app.data.model.Book
import com.example.book_search_app.databinding.ItemBookPreviewBinding

class BookSearchViewHolder (
    private val binding: ItemBookPreviewBinding
        ) : RecyclerView.ViewHolder(binding.root) {
            fun bind(book: Book) {
                val author = book.authors.toString().removeSurrounding("[", "]") //author이 list 형식이기 때문에 좌우에 []을 삭제했다
                val publisher = book.title
                val date = if(book.datetime.isNotEmpty()) book.datetime.substring(0,10) else "" //null 이 들어올 수 있기 때문에 조건문 사용, 10자리만 가져오면 되기 때문에 substring 사용


                itemView.apply {
                    binding.ivArticleImage.load(book.thumbnail)
                    binding.tvTitle.text = book.title
                    binding.tvAuthor.text = "$author | $publisher"
                    binding.tvDatetime.text = date
                }
            }
        }