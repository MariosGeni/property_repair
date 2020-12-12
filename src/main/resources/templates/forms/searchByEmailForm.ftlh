
    <h2 class="">Search for a User</h2>

<form action="/owners/search" name="searchForm" method="POST">
    <div class="form-group">
        <label>Search by</label>
        <select class="form-control">
            <option value="afm">ΑΦΜ</option>
            <option value="email">Email</option>
        </select>
    </div>
    
    <div class="mb-3">
        <label for="email">  </label>
        <div class="input-group">
            <input type="email" name="email" id="email" placeholder="email">
        </div>
    </div>
    <button type="submit">Search</button>

    
</form>