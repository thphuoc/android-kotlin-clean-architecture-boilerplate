package android.contact.data.local.entity

data class BankAccountEntity (private val id: Int,
                              private val contactId: Int,
                              private val accountNumber: String,
                              private val bankName: String,
                              private val bankBranch: String)